package smbms.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class RESTControl {
	//查询列表
	@RequestMapping(value="/product",method=RequestMethod.GET)
     public ModelAndView getProduct(){
    	 System.out.println("商品列表功能实现");
    	 return null;
     }
	//根据id查询
	@RequestMapping(value="/product/{id}",method=RequestMethod.GET)
	public ModelAndView productList(@PathVariable String id){
		System.out.println("查询0"+id+"号商品信息");
		return null;
	}
    //添加商品信息
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public ModelAndView addProduct(){
		System.out.println("新商品添加");
		return null;
	}
	@RequestMapping(value="/product/{id}",method=RequestMethod.DELETE)
	public ModelAndView deleteProduct(){
		System.out.println("删除商品");
		return null;
	}
	@RequestMapping(value="/product",method=RequestMethod.PUT)
	public ModelAndView updateProduct(){
		System.out.println("更新商品");
		return null;
	}
}
