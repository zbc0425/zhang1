package smbms.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class RESTControl {
	//��ѯ�б�
	@RequestMapping(value="/product",method=RequestMethod.GET)
     public ModelAndView getProduct(){
    	 System.out.println("��Ʒ�б���ʵ��");
    	 return null;
     }
	//����id��ѯ
	@RequestMapping(value="/product/{id}",method=RequestMethod.GET)
	public ModelAndView productList(@PathVariable String id){
		System.out.println("��ѯ0"+id+"����Ʒ��Ϣ");
		return null;
	}
    //�����Ʒ��Ϣ
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public ModelAndView addProduct(){
		System.out.println("����Ʒ���");
		return null;
	}
	@RequestMapping(value="/product/{id}",method=RequestMethod.DELETE)
	public ModelAndView deleteProduct(){
		System.out.println("ɾ����Ʒ");
		return null;
	}
	@RequestMapping(value="/product",method=RequestMethod.PUT)
	public ModelAndView updateProduct(){
		System.out.println("������Ʒ");
		return null;
	}
}
