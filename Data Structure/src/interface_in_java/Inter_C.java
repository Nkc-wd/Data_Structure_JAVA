package interface_in_java;

 class Inter_C implements Call_me {

	public static void main(String[] args) {
		
      Inter_C ic=new Inter_C();
      ic.my_interface();
	}

	// You have to add method in Inter_c class which is implements by interface Call_me
	@Override
	public void my_interface() {
System.out.println("i am interface from Inter_C class");
		
	}

}
