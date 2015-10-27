import org.apache.hadoop.io.GenericWritable;
import org.apache.hadoop.io.Writable;

 
public class JoinGenericWritable extends GenericWritable{
  public static Class<? extends Writable>[] CLASSES =null;
  
  static{
	  CLASSES =(Class<? extends Writable>[]) new Class[]{
		  StudentAddressDetail.class,
		  StudentAcademicDetails.class
	  };
	  
	 }
  
  public JoinGenericWritable() {}
  
  public JoinGenericWritable(Writable instance){
	  set(instance);
  }
  
  public Class<? extends Writable>[] getTypes(){
	  return CLASSES;
  }
}
