package dld;



public class My1 {
	public static void main(String[] args) {
		
		String str = "12 3 4 java";
		System.out.println(str.length());
		System.out.println(str.contains("java"));
		char[] arr = {'a','w','e','u'};
		String str1 = new String(arr);
		String str2 = new String(arr,1,2);
		
		System.out.println(str1);
		System.out.println(str2.valueOf(arr));
		System.out.println(str2);
		
		
	
		
	}
}