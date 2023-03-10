package Logica;

import java.io.File;
import java.util.LinkedList;


public class Calcular {
	
	private File file;
	
	public Calcular () {
	
	}
public File getFile () {
	return file;
}
public void  setFile (File file) {
	this.file=file;
}
public  long  calcularEspacio (File file) {
	System.out.print(file.length());
	return file.length();

}

private void recursive(File dir, LinkedList<File> lista) {

	
    File listFile[] = dir.listFiles();
    File listDir[];
    
    if (listFile != null && listFile.length > 0) {
        for (int i = 0; i < listFile.length; i++) {
            if (listFile[i].isDirectory()){
                listDir = listFile[i].listFiles();
               
                recursive(listFile[i], lista);
            } else if(listFile[i].isFile()){
            	
            	lista.add(listFile[i]);
            }
        }
    }
}

public LinkedList<String> TresMasGrandes (File file) {
	
	LinkedList<File> r=new LinkedList<File>();
	recursive(file,r);
	LinkedList<String> retorno= new LinkedList<String>();
	
	File[] arr = new File [r.size()];
	int n=0;
	
	for (File f : r) {
		arr[n] = f;
		n++;
	}	
	

	//bubbleSort
	for(int i=0 ;i<n-1; i++) {
		for(int j=0;j<n-i-1;j++) {
			if(arr[j].length()<arr[j+1].length()) {
				//swap
				File temp=arr[j];
				arr[j] = arr[j+1];
				arr[j+1]=temp;
			}
		}
	}
	
	if (arr.length >=1) {
		retorno.addLast(arr[0].getName());}
	if (arr.length>=2) {
		retorno.addLast(arr[1].getName());}
	if (arr.length>=3) {
		retorno.addLast(arr[2].getName());}
		
	 return retorno;
} 


}
