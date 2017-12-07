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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;

import smbms.entity.Provider;
import smbms.entity.User;
import smbms.service.ProviderService;

@Controller
@RequestMapping("/provider")
public class ProviderControl {
   @Autowired
   private ProviderService providerService;
   @RequestMapping(method=RequestMethod.GET)
   public ModelAndView listProvider(Integer pageIndex,String queryProCode,String queryProName) throws Exception{
	   Map<String,Object> param =new HashMap<String, Object>();
	   int pageNo =1;
	   if(pageIndex != null){
		   pageNo=pageIndex.intValue();
	   }
	   param.put("start", pageNo);
	   param.put("size",  5);
	   //模糊查询
	   param.put("proCode",queryProCode);
	   param.put("proName", queryProName);
	   List<Provider> providerList =providerService.getProviderListByMap(param);
	   Page<Provider> page = (Page<Provider>) providerList;
	   ModelAndView mv =new ModelAndView();
	   mv.addObject("totalCount", page.getTotal());
	   mv.addObject("totalPageCount", page.getPages());
	   mv.addObject("currentPageNo", pageNo);
	   mv.addObject("providerList", page);
	   mv.addObject("queryProCode",queryProCode);
	   mv.addObject("queryProName", queryProName);
	   mv.setViewName("providerlist");
	   return mv;
	   /*Page<Provider> providerList =(Page<Provider>) providerService.getProviderListByMap(param);
	   HashMap<String,Object> model =new HashMap<String, Object>();
	   model.put("totalCount", providerList.getTotal());
	   model.put("totalPageCount", providerList.getPages());
	   model.put("currentPageNo", pageno);
	   model.put("providerList", providerList);
	   return new ModelAndView("providerlist",model);
	   */
   }
   @RequestMapping(method=RequestMethod.POST)
   public ModelAndView addProvider(@Valid Provider provider,BindingResult result,
		   MultipartFile idPicPath,HttpServletRequest request) throws Exception{
	   ModelAndView mv =new ModelAndView();
	   String path =request.getServletContext().getRealPath("/upload");
	   String fileName =idPicPath.getOriginalFilename();
	   String ext =FilenameUtils.getExtension(fileName);
	   fileName =UUID.randomUUID().toString()+"."+ext;
	   File file =new File(path +"/"+ fileName);
	   idPicPath.transferTo(file);
	   provider.setIdPicPath("upload/" + fileName);
	   int count =providerService.insertProvider(provider);
	   if(count>0){
		    mv.setViewName("redirect:/provider");
	   }else{
		   mv.setViewName("provideradd");
	   }
	   return mv;
   }
   @RequestMapping(value="{id}",method=RequestMethod.GET)
   public ModelAndView getProvider(@PathVariable Integer id) throws Exception{
	   ModelAndView mv =new ModelAndView();
	   Provider provider =providerService.getProviderById(id);
	   mv.addObject("provider", provider);
	   mv.setViewName("providerview");
	   return mv;   
   }
}
