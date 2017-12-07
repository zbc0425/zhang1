package smbms.control;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;

import smbms.entity.Role;
import smbms.entity.User;
import smbms.service.RoleService;
import smbms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserControl {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	/**
	 * 登陆
	 * @param loginuser 实体类参数
	 * @param result   非空验证的参数
	 * @return
	 */
    @RequestMapping("/dologin.html")
    public ModelAndView userLogin(@Valid User loginuser,BindingResult result){
    	ModelAndView mv =new ModelAndView();
    	if(result.hasErrors()==true){
    		mv.setViewName("login");
    		return mv;
    	}
    	User user =userService.login(loginuser.getUsercode(),
    			                     loginuser.getUserpassword());
    	//User user =null;
    	if(user!=null){
    		 mv.setViewName("frame");
    	}else{
    		mv.addObject("error","用户名或密码不正确");
    		mv.setViewName("login");
    	}
    	return mv;
    }
      @RequestMapping(value="/valid",produces="application/json;charset=utf-8")
      @ResponseBody
      public String validateUserCode(String userCode) throws Exception{
    	  HashMap<String,Object> param =new HashMap<String, Object>();
    	  param.put("userCode", userCode);
    	  List<User> list =userService.getUserListByMap(param);
    	  HashMap<String,Object> result =new HashMap<String, Object>();
    	  if(list.size()>0){
    		  result.put("result", false);
    		  result.put("message", "用户账号已经存在");
    	  }else{
    		  result.put("result", true);
    	  }
    	  return JSONArray.toJSONString(result);
      }
/*    @RequestMapping("userlist.html")
    public ModelAndView userList(){
   	    ModelAndView mv =new ModelAndView();
   	    List<User> list =userService.findAll();
   	    mv.addObject("userList", list);
   	    mv.setViewName("userlist");
   	    return mv;
    }*/
/*    @RequestMapping("useradd.html")
    public ModelAndView openRegUser(){
    	return new ModelAndView("useradd");
    }*/
    /**
     * 用户列表
     * @return
     * @throws Exception
     */
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView userList(Integer pageIndex,String queryname,
    		Integer queryUserRole) throws Exception{
    	ModelAndView mv =new ModelAndView();
    	Map<String, Object> param =new HashMap<String, Object>();
    	int pageNo=1;
    	if(pageIndex!=null){
    		pageNo=pageIndex.intValue();
    	}
    	param.put("start", pageNo);
    	param.put("size", 5);
    	param.put("userName", queryname);
        if(queryUserRole!=null && queryUserRole != 0){
    	param.put("userRole", queryUserRole);
        }
    	List<User> userList =userService.getUserListByMap(param);
    	Page<User> page =(Page<User>) userList;
        //总记录数
    	mv.addObject("totalCount", page.getTotal());
    	//总页数
    	mv.addObject("totalPageCount", page.getPages());
    	//当前页码
    	mv.addObject("currentPageNo", pageNo);
    	mv.addObject("userList", page);
    	mv.addObject("queryUserName", queryname);
    	mv.addObject("queryUserRole", queryUserRole);
    	
    	List<Role> roleList =roleService.getRoleListByMap(null);
    	mv.addObject("roleList", roleList);
    	mv.setViewName("userlist");
    	return mv;
    }
    /**
     * 用户注册
     * @param reguser  实体类对象
     * @param result   非空参数
     * @param idPicPath 上传照片参数
     * @param request  
     * @return
     * @throws Exception
     */
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView userRegist(@Valid User reguser,BindingResult result,
    		MultipartFile idPicPath,HttpServletRequest request) throws Exception{
    	ModelAndView mv =new ModelAndView();
    	/*if(result.hasErrors()){
    		mv.setViewName("useradd");
    	}else{*/
    	    String path =request.getServletContext().getRealPath("/upload");
    		String fileName =idPicPath.getOriginalFilename();
    		String ext =FilenameUtils.getExtension(fileName);
    		fileName =UUID.randomUUID().toString()+"."+ext;
    		File file =new File(path + "/" + fileName);
    				/*new File("D:/zbc/eclisp/upload"+fileName);*/
    		idPicPath.transferTo(file);
    		reguser.setIdpicpath("upload/" + fileName);
    		int count=userService.insertUser(reguser);
    		if(count>0){
    			mv.setViewName("redirect:/user");
    		}else{
    			mv.setViewName("useradd");
    		}
    		
    	/*}*/
    	return mv;
    }
}
