package com.ba.factory;

public class FileExporterFactory {
	public static FileExporter getInstance(FileType fileType) {
		switch(fileType) {
		case EXCEL: return new ExcelExporter();
		case PDF: return new PdfExporter();
		default: throw new UnsupportedOperationException();
		
		}
	}
	
	public enum FileType{
		PDF,
		EXCEL;
	}
	
	//Bu pattern ayný tipteki nesnelerin üretmeyi tek bir noktadan yaparak kod tekrarýný engeller
	// Ve daha saonra kullanacak olan developerlar iþin arkasýndaki kýsýmlarý bilmeden gerekli parametreleri vererek doðrudan o classlara eriþmeden kullanabilirler
}
