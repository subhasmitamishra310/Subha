package org.oar.mama;

public class HeapSort {
	public static void main(String[] args) {
		int[]a= {7,4,8,1,9,2,8};
		HeapSort hs=new HeapSort();
		hs.sort(a);
		hs.printArray(a);
	}
	 void sort(int[]a) {
		int leng=a.length;
		for(int i=leng/2-1;i>=0;i--)
		{
			heapfy(a,leng,i);
		}
		for(int i=leng-1;i>=0;i--)
		{
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			heapfy(a,i,0);
		}
	}
	private void heapfy(int[] a, int n, int i) 
	{
		int largest=i;
		int li=2*i+1;
		int ri=2*i+2;
		if(li<n && a[li]>a[largest])
		{
			largest=li;
		}
		if(ri<n && a[ri]>a[largest])
		{
			largest=ri;
		}
		if(largest!=i)
		{
			int temp=a[i];
			a[i]=a[largest];
			a[largest]=temp;
			heapfy(a,n,largest);
		}
		
	}
	void printArray(int[]a)
	{
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]+" ");
	}
	}

}
