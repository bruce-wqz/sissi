package com.sissi.protocol.iq.search;

import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sissi.field.Field;
import com.sissi.field.Fields;
import com.sissi.field.impl.BeanFields;
import com.sissi.io.read.Collector;
import com.sissi.io.read.Metadata;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.iq.data.XData;
import com.sissi.protocol.iq.search.field.Email;
import com.sissi.protocol.iq.search.field.First;
import com.sissi.protocol.iq.search.field.Instructions;
import com.sissi.protocol.iq.search.field.Item;
import com.sissi.protocol.iq.search.field.Last;
import com.sissi.protocol.iq.search.field.Nick;

/**
 * @author kim 2014年6月6日
 */
@Metadata(uri = Search.XMLNS, localName = Search.NAME)
@XmlType(namespace = Search.XMLNS)
@XmlRootElement(name = Search.NAME)
public class Search extends Protocol implements Fields, Collector {

	public final static String XMLNS = "jabber:iq:search";

	public final static String NAME = "query";

	private final BeanFields fields = new BeanFields(false);

	private XData data;

	@XmlAttribute
	public String getXmlns() {
		return XMLNS;
	}

	@XmlElements({ @XmlElement(name = XData.NAME, type = XData.class), @XmlElement(name = Email.NAME, type = Email.class), @XmlElement(name = First.NAME, type = First.class), @XmlElement(name = Last.NAME, type = Last.class), @XmlElement(name = Nick.NAME, type = Nick.class), @XmlElement(name = Item.NAME, type = Item.class), @XmlElement(name = Instructions.NAME, type = Instructions.class) })
	public List<Field<?>> getFields() {
		return this.fields.getFields();
	}

	public Search x(XData data) {
		this.data = data;
		return this;
	}

	@XmlElement
	public XData getX() {
		return this.data;
	}

	public Search add(Field<?> field) {
		this.fields.add(field);
		return this;
	}

	public Search add(Fields fields) {
		this.fields.add(fields);
		return this;
	}

	@Override
	public void set(String localName, Object ob) {
		switch (localName) {
		case XData.NAME:
			this.x(XData.class.cast(ob));
		default:
			this.add(Field.class.cast(ob));
		}
	}

	public Search addField(Field<?> field) {
		this.fields.add(field);
		return this;
	}

	@Override
	public Iterator<Field<?>> iterator() {
		return this.fields.iterator();
	}

	public Fields findFields(String name) {
		return this.fields.findFields(name);
	}

	@Override
	public <T extends Field<?>> T findField(String name, Class<T> clazz) {
		return this.fields.findField(name, clazz);
	}

	@Override
	public boolean isEmbed() {
		return this.fields.isEmbed();
	}

	public boolean isEmpty() {
		return this.fields.isEmpty();
	}

	public Search clear() {
		this.fields.reset();
		return this;
	}

	public boolean form(boolean needForm) {
		return (this.getX() != null) == needForm;
	}
}
