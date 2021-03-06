package com.sissi.field.impl;

import java.util.ArrayList;
import java.util.List;

import com.sissi.field.Field;
import com.sissi.field.Fields;

/**
 * @author kim 2013年12月11日
 */
public class BeanField<T> implements Field<T> {

	private List<Field<?>> children;

	private boolean isEmbed;

	private String name;

	private T value;

	public BeanField() {
		this(false);
	}

	public BeanField(boolean isEmbed) {
		super();
		this.isEmbed = isEmbed;
	}

	public BeanField<T> name(String name) {
		this.name = name;
		return this;
	}

	public BeanField<T> value(T value) {
		this.value = value;
		return this;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public T getValue() {
		return this.value;
	}

	public BeanField<T> add(Field<T> field) {
		if (this.children == null) {
			this.children = new ArrayList<Field<?>>();
		}
		this.children.add(field);
		return this;
	}

	@Override
	public Fields getChildren() {
		return this.hasChild() ? new BeanFields(this.isEmbed, this.children) : null;
	}

	@Override
	public boolean hasChild() {
		return this.children != null && !this.children.isEmpty();
	}
}
