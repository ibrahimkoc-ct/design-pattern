package com.ba.factory;

class ExcelExporter implements FileExporter{
	

	public String export(String content) {
		return "EXCEL -> "+ content;
	}

}
