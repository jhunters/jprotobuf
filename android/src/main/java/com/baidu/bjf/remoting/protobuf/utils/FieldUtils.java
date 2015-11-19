/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.bjf.remoting.protobuf.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Field utility class.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public final class FieldUtils {

	private static final Map<String, String> PRIMITIVE_TYPE_MAPPING;

	static {

		PRIMITIVE_TYPE_MAPPING = new HashMap<String, String>();

		PRIMITIVE_TYPE_MAPPING.put(int.class.getSimpleName(), Integer.class.getSimpleName());
		PRIMITIVE_TYPE_MAPPING.put(long.class.getSimpleName(), Long.class.getSimpleName());
		PRIMITIVE_TYPE_MAPPING.put(short.class.getSimpleName(), Short.class.getSimpleName());
		PRIMITIVE_TYPE_MAPPING.put(boolean.class.getSimpleName(), Boolean.class.getSimpleName());
		PRIMITIVE_TYPE_MAPPING.put(double.class.getSimpleName(), Double.class.getSimpleName());
		PRIMITIVE_TYPE_MAPPING.put(float.class.getSimpleName(), Float.class.getSimpleName());
		PRIMITIVE_TYPE_MAPPING.put(char.class.getSimpleName(), Character.class.getSimpleName());
		PRIMITIVE_TYPE_MAPPING.put(byte.class.getSimpleName(), Byte.class.getSimpleName());
	}

	/**
	 * Logger for this class
	 */
	private static final Logger LOGGER = Logger.getLogger(FieldUtils.class.getName());

	public static String getUnboxedFieldname(String name, String primitiveType) {
		if (PRIMITIVE_TYPE_MAPPING.containsKey(primitiveType)) {
			return PRIMITIVE_TYPE_MAPPING.get(primitiveType) + ".valueOf(" + name + ")";
		}
		return name;
	}

	public static String getInBoxedFieldname(String name, String primitiveType) {
		if (PRIMITIVE_TYPE_MAPPING.containsValue(primitiveType)) {
			return primitiveType + ".valueOf(" + name + ")";
		}
		return name;
	}

	public static String toObjectType(String primitiveType) {
		if (PRIMITIVE_TYPE_MAPPING.containsKey(primitiveType)) {
			return PRIMITIVE_TYPE_MAPPING.get(primitiveType);
		}
		return ClassHelper.getInternalName(primitiveType);
	}

	/**
	 * Get the field represented by the supplied {@link Field field object} on
	 * the specified {@link Object target object}. In accordance with
	 * {@link Field#get(Object)} semantics, the returned value is automatically
	 * wrapped if the underlying field has a primitive type.
	 * <p>
	 * Thrown exceptions are handled via a call to
	 * 
	 * @param t
	 *            the target object from which to get the field
	 * @param name
	 *            the field to get
	 * @return the field's current value
	 */
	public static Object getField(Object t, String name) {
		Field field = findField(t.getClass(), name);
		return getField(t, field);
	}

	/**
	 *
	 * @param t
	 * @param field
	 * @return
	 */
	public static Object getField(Object t, Field field) {
		if (field == null) {
			return null;
		}
		field.setAccessible(true);
		try {
			return field.get(t);
		} catch (Exception e) {
			LOGGER.log(Level.FINE, e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Set the field represented by the supplied {@link Field field object} on
	 * the specified {@link Object target object} to the specified
	 * <code>value</code>. In accordance with {@link Field#set(Object, Object)}
	 * semantics, the new value is automatically unwrapped if the underlying
	 * field has a primitive type.
	 * <p>
	 * Thrown exceptions are handled via a call to
	 * 
	 * @param t
	 *            the target object on which to set the field
	 * @param name
	 *            the field to set
	 * @param value
	 *            the value to set; may be <code>null</code>
	 */
	public static void setField(Object t, String name, Object value) {
		Field field = findField(t.getClass(), name);
		setField(t, field, value);
	}

	public static void setField(Object t, Field field, Object value) {
		if (field == null) {
			return;
		}
		field.setAccessible(true);
		try {
			field.set(t, value);
		} catch (Exception e) {
			LOGGER.log(Level.FINE, e.getMessage(), e);
		}
	}
	
	public static void setField(Object t, String name, int value) {
		setField(t, name, Integer.valueOf(value));
	}
	
	public static void setField(Object t, Field field, int value) {
		setField(t, field, Integer.valueOf(value));
	}

	public static void setField(Object t, String name, short value) {
		setField(t, name, Short.valueOf(value));
	}
	
	public static void setField(Object t, Field field, short value) {
		setField(t, field, Short.valueOf(value));
	}

	public static void setField(Object t, String name, double value) {
		setField(t, name, Double.valueOf(value));
	}
	
	public static void setField(Object t, Field field, double value) {
		setField(t, field, Double.valueOf(value));
	}

	public static void setField(Object t, String name, float value) {
		setField(t, name, Float.valueOf(value));
	}
	
	public static void setField(Object t, Field field, float value) {
		setField(t, field, Float.valueOf(value));
	}

	public static void setField(Object t, String name, byte value) {
		setField(t, name, Byte.valueOf(value));
	}
	
	public static void setField(Object t, Field field, byte value) {
		setField(t, field, Byte.valueOf(value));
	}

	public static void setField(Object t, String name, char value) {
		setField(t, name, Character.valueOf(value));
	}
	
	public static void setField(Object t, Field field, char value) {
		setField(t, field, Character.valueOf(value));
	}

	public static void setField(Object t, String name, long value) {
		setField(t, name, Long.valueOf(value));
	}
	
	public static void setField(Object t, Field field, long value) {
		setField(t, field, Long.valueOf(value));
	}

	public static void setField(Object t, String name, boolean value) {
		setField(t, name, Boolean.valueOf(value));
	}
	
	public static void setField(Object t, Field field, boolean value) {
		setField(t, field, Boolean.valueOf(value));
	}

	public static void addList(List list, Object value) {
		if (list != null) {
			list.add(value);
		}
	}

	public static void addList(List list, int value) {
		addList(list, Integer.valueOf(value));
	}

	public static void addList(List list, short value) {
		addList(list, Short.valueOf(value));
	}

	public static void addList(List list, double value) {
		addList(list, Double.valueOf(value));
	}

	public static void addList(List list, float value) {
		addList(list, Float.valueOf(value));
	}

	public static void addList(List list, byte value) {
		addList(list, Byte.valueOf(value));
	}

	public static void addList(List list, char value) {
		addList(list, Character.valueOf(value));
	}

	public static void addList(List list, long value) {
		addList(list, Long.valueOf(value));
	}

	public static void addList(List list, boolean value) {
		addList(list, Boolean.valueOf(value));
	}

	/**
	 * Attempt to find a {@link Field field} on the supplied {@link Class} with
	 * the supplied <code>name</code>. Searches all superclasses up to
	 * {@link Object}.
	 * 
	 * @param clazz
	 *            the class to introspect
	 * @param name
	 *            the name of the field
	 * @return the corresponding Field object, or <code>null</code> if not found
	 */
	public static Field findField(Class clazz, String name) {
		return findField(clazz, name, null);
	}

	/**
	 * Attempt to find a {@link Field field} on the supplied {@link Class} with
	 * the supplied <code>name</code> and/or {@link Class type}. Searches all
	 * superclasses up to {@link Object}.
	 * 
	 * @param clazz
	 *            the class to introspect
	 * @param name
	 *            the name of the field (may be <code>null</code> if type is
	 *            specified)
	 * @param type
	 *            the type of the field (may be <code>null</code> if name is
	 *            specified)
	 * @return the corresponding Field object, or <code>null</code> if not found
	 */
	public static Field findField(Class clazz, String name, Class type) {
		if (clazz == null) {
			throw new IllegalArgumentException("Class must not be null");
		}
		if (name == null && type == null) {
			throw new IllegalArgumentException("Either name or type of the field must be specified");
		}
		Class searchType = clazz;
		while (!Object.class.equals(searchType) && searchType != null) {
			Field[] fields = searchType.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				if ((name == null || name.equals(field.getName())) && (type == null || type.equals(field.getType()))) {
					return field;
				}
			}
			searchType = searchType.getSuperclass();
		}
		return null;
	}

	/**
	 * To find out matched {@link Field} marked as {@link Protobuf} annotation
	 * 
	 * @param targetClass
	 *            taget class
	 * @return found {@link Field} list
	 */
	public static List<Field> findMatchedFields(Class targetClass, Class ann) {

		List<Field> ret = new ArrayList<Field>();
		if (targetClass == null) {
			return ret;
		}

		// Keep backing up the inheritance hierarchy.
		do {
			// Copy each field declared on this class unless it's static or
			// file.
			Field[] fields = targetClass.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Annotation protobuf = fields[i].getAnnotation(ann);
				if (protobuf != null) {
					ret.add(fields[i]);
				}
			}
			targetClass = targetClass.getSuperclass();
		} while (targetClass != null && targetClass != Object.class);

		return ret;
	}
}
