package com.atomic.hadoop.common.oozie.model.coordinator;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class OwCoordinatorParameters {
	
	@XStreamImplicit(itemFieldName = "property")
	private List<OwCoordinatorProperty> propertys = new ArrayList<OwCoordinatorProperty>();

	public List<OwCoordinatorProperty> getPropertys() {
		return propertys;
	}

	public void setPropertys(List<OwCoordinatorProperty> propertys) {
		this.propertys = propertys;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((propertys == null) ? 0 : propertys.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		OwCoordinatorParameters other = (OwCoordinatorParameters) obj;
		if (propertys == null) {
			if (other.propertys != null){
				return false;
			}
		} else if (!propertys.equals(other.propertys)){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "OwCoordinatorParameters [propertys=" + propertys + "]";
	}

	public static OwCoordinatorParameters parseXml(Element element) {
		OwCoordinatorParameters oc =new OwCoordinatorParameters();
		List<Element> propEs = element.elements("property");
		oc.propertys=OwCoordinatorProperty.parseXml(propEs);
		return oc;
	}
}
