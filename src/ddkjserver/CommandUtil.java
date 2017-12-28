package ddkjserver;

import java.util.List;

public class CommandUtil {
	/*
//	public Command open(){
//		Command command = new Command();
//		command.set_1AH((byte) 0xC1);
//		command.setFUN((byte) 0x37);
//		command.setNEXT(new byte[]{0x55,0x00,0x01});
//		command.setDATA(new byte[]{0x00,0x07,1});
//		command.setCS((byte)MOD(0xC1+0x37+0x55+0x00+0x04+0x07,256));
//		command.set_1AH((byte)0x1A);
//		return command;
//	}

//	private int MOD(int... i) {
//		int m = 0;
//		for(int j:i){
//			m = m+j;
//		}
//		return m;
//	}*/   
	
 
    
    public static String cs(String data) { 
    	if (data == null || data.equals("")) {
    		return ""; } 
    	int total = 0; 
    	int len = data.length(); 
    	int num = 0; 
    	while (num < len) { 
    		String s = data.substring(num, num + 2); 
    		System.out.println(s); 
    		total += Integer.parseInt(s, 16); 
    		num = num + 2; } 
    	int mod = total % 256; 
    	String hex = Integer.toHexString(mod); 
    	len = hex.length(); // 如果不够校验位的长度，补0,这里用的是两位校验 
    	if (len < 2) { hex = "0" + hex; } 
    	return hex;
    	}
    

}
