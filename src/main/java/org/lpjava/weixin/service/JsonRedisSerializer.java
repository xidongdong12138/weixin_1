package org.lpjava.weixin.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;

import org.lpjava.weixin.domain.InMessage;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRedisSerializer extends Jackson2JsonRedisSerializer<Object> {

	private ObjectMapper objectMapper = new ObjectMapper();

	public JsonRedisSerializer() {
		super(Object.class);
	}

	@Override
	public byte[] serialize(Object t) throws SerializationException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(baos);
		try {
			String className = t.getClass().getName();
			byte[] classNameBytes = className.getBytes("UTF-8");

			out.writeInt(classNameBytes.length);
			out.write(classNameBytes);

			byte[] data = super.serialize(t);
			out.write(data);

			byte[] result = baos.toByteArray();
			return result;
		} catch (Exception e) {
			throw new SerializationException("序列化对象出现问题：" + e.getLocalizedMessage(), e);
		}
//		return super.serialize(t);
	}

	@Override
	public InMessage deserialize(byte[] bytes) throws SerializationException {

		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		DataInputStream in = new DataInputStream(bais);

		try {
			int length = in.readInt();
			byte[] classNameBytes = new byte[length];
			in.readFully(classNameBytes);
			
			String className = new String(classNameBytes, "UTF-8");
			@SuppressWarnings("unchecked")
			Class<? extends InMessage> cla = (Class<? extends InMessage>) Class.forName(className);

			return this.objectMapper.readValue(Arrays.copyOfRange(bytes, length + 4, bytes.length), cla);
		} catch (Exception e) {
			throw new SerializationException("反序列化对象出现问题：" + e.getLocalizedMessage(), e);
		}

//		return super.deserialize(bytes);
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
}
