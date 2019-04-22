
package util;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NavigationBean implements Serializable {
   public String page(String p){
       return "/module/"+p+"/"+p+"?faces-redirct-true";
   } 
}
