package br.com.quintoandar.desk.com.cases;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CaseStatus {
	neww("new"), open, pending, resolved, closed;
	
	private String strValue;
	
	private CaseStatus(){
		this(null);
	}
	
	private CaseStatus(String strValue){
		this.strValue = strValue;
	}
	
	public static CaseStatus fromString(String val){
		for(CaseStatus cs:CaseStatus.values()){
			if(cs.toString().equals(val)){
				return cs;
			}
		}
		return CaseStatus.valueOf(val);
	}
	
	@JsonValue
	public String getStrValue() {
		return strValue;
	}

	@Override
	public String toString() {
		if(strValue != null){
			return strValue;
		}
		return super.toString();
	}
	
}
