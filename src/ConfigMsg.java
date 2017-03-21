
public class ConfigMsg {
	
	public static void Decifer(String msg){
		String[] split = msg.split("-");
		System.out.println(split.length);

		switch (split[0]) {
		case "MOVX":
			MovementOfCerberus.movX = 1;
			break;
			
		case "MOVY":
			MovementOfCerberus.movY = Integer.parseInt(split[1]);
			break;
			
		case "MOVZ":
			MovementOfCerberus.movZ = Integer.parseInt(split[1]);
			break;

		default:
			break;
		}
	}

}
