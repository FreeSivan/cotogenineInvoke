package com.configure.metadata;

public class MetaDataInput {
	
	private Integer index;
	
	private Class<?> clazz;
	
	private Object object;
	
	public MetaDataInput() {
		
	}
	
	public MetaDataInput(Integer index, Class<?> clazz, Object object) {
		this.index = index;
		this.clazz = clazz;
		this.object = object;
	}
	
	public Integer getIndex() {
		return index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public Class<?> getClazz() {
		return clazz;
	}
	
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	
}
