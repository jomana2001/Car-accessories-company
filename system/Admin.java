package system;

public class Admin {
	boolean logState;
	String username;
	String pass;
	String email;
	String phone;
	public Admin() {
		username ="leen.aljaber123@gmail.com";
		pass="12345l";
	}
	public Admin (String username ,String pass,String email,String phone) {
		this.username=username;
		this.pass=pass;
		this.email=email;
		this.phone=phone;
	}
	public void setLoginState(boolean b) {
		logState=b;	
	}
	public boolean getLoginState() {
		return logState;
		}
	public boolean login(String username,String pass) {
		if(logState) {
			
			return false;
			}
		else {
			if(username.equals("leen.aljaber123@gmail.com") && pass.equals("12345l")) {
				logState=true;
				return true;}
			else {
				return false;
					}
			}
		}

	
	
		public void logOut() {
			
			if(logState) {
				logState=false;
			}
			
			
		}
		public Status setStatus(Order o ,Status s) {
			o.setStatus(s);
			return s;
		}
		
		public boolean distribute(MySystem ms, Order o) {
		    int index = -1;
		    for (int i = 0; i < ms.workers.size(); i++) {
		        if (ms.workers.get(i).getIsFree()) {
		            o.wId = ms.workers.get(i).id;
		            ms.workers.get(i).setIsFree(false);
		            o.setStatus(Status.INTREATMENT);
		            index = 1;
		            break;
		        }
		    }
		    return index == 1;
		}
		
		}
		
		
	
	


