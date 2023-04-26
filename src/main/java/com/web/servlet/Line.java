package com.web.servlet;
import java.util.ArrayList;
import java.util.List;

public class Line {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getStations() {
		return stations;
	}
	public void setStations(List<String> line) {
		this.stations = line;
	}
	private String name;
	private List<String> stations = new ArrayList<String>();//����·�ϵ�����վ��
}
