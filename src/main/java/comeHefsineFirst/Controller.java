package comeHefsineFirst;



import java.lang.reflect.Array;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Controller {
		@Autowired
        FooditemRepo fooditemrepo;
		@Autowired
		UserRepo userrepo;
		@Autowired
		RequestRepo requestrepo;
		
		
		
		@RequestMapping("/hii")
		public int hii()
		{
			System.out.println("hiiii");

		return 1;
		}
		
		@RequestMapping("filter{nutrition}with{density}")
		public List<Fooditem >filter(@PathVariable("nutrition") String nutrition,@PathVariable("density") String density)
		{
			try {
				
			if(nutrition.equals("protein"))
			{
				if(density.equals("High"))
				{
					return fooditemrepo.findAllOrderByProteinDesc();
				}
				else if(density.equals("Low"))
				{
				 return fooditemrepo.findAllOrderByProteinAsc();
				}
				
			}
			else if(nutrition.equals("goodfat"))
			{
				if(density.equals("High"))
				{
					return fooditemrepo.findAllOrderByGoodfatDesc();
				}
				else if(density.equals("Low"))
				{
				 return fooditemrepo.findAllOrderByGoodfatAsc();
				}
				
				
			}
			else if(nutrition.equals("badfat"))
			{
				if(density.equals("High"))
				{
					return fooditemrepo.findAllOrderByBadfatDesc();
				}
				else if(density.equals("Low"))
				{
				 return fooditemrepo.findAllOrderByBadfatAsc();
				}
				
				
			}
			else if(nutrition.equals("carbohydrates"))
			{
				if(density.equals("High"))
				{
					return fooditemrepo.findAllOrderByCarbohydratesDesc();
				}
				else if(density.equals("Low"))
				{
				 return fooditemrepo.findAllOrderByCarbohydratesAsc();
				}
				
			}
				
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return null;
		}
		
		
		@RequestMapping("/availableRequest{s}")
		public int availableRequest(@PathVariable("s") String s)
		{
			//0 error on server
			//1 already in database
			//2 no records in database
			//3 something wrong
			try
			{
				int a=requestrepo.countByFooditem(s);
				if(a>0)
				return 1;
				else if(a==0)
					return 2;
				else
					return 3;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return 0;
			}
		}
		
		@RequestMapping("/available{s}")
		public int available(@PathVariable("s") String s)
		{
			//0 error on server
			//1 already in database
			//2 no records in database
			//3 something wrong
			try
			{
				int a=fooditemrepo.find_available(s);
				if(a>0)
				return 1;
				else if(a==0)
					return 2;
				else
					return 3;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return 0;
			}
		}
		
		@RequestMapping("/search")
		public List<Fooditem> search(@RequestBody String s)
		{
			System.out.println("checking");
			try
			{
				List<Fooditem> fooditem=fooditemrepo.Search(s);
				return fooditem;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
		}
		
		@RequestMapping("/report")
		public int report(@RequestBody String s)
		{
			//1->successfull
			//2->error at server
			try {
			Request request=new Request();
			request.setFooditem(s);
			request.setStatus(0);
			requestrepo.save(request);
			return 1;
			}
			catch(Exception e) 
			{
				e.printStackTrace();
				return 0;
			}
		}
		
		@RequestMapping("/rejected{reqId}")
		public int rejected(@RequestBody String [] s,@PathVariable("reqId") int reqId)
		{
			try {
				int a=2;
				int b=reqId;
			Request request=requestrepo.findById(b);
			request.setReject_Reason(s[0]);
			request.setStatus(a);
			requestrepo.save(request);
			return 1;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return 0;
			}
		}
		
		@RequestMapping("/markstatus")
		public int markstatus(@RequestBody int a)
		{
			// 1-> successful
			//2 -> error
			try {
			Request request=requestrepo.findById(a);
			request.setReject_Reason("added");
			request.setStatus(1);
			requestrepo.save(request);
			return 1;
			}
			catch(Exception e)
			{
				e.printStackTrace();

				return 0;
			}
		}
		
		@RequestMapping("/add")
		public int add(@RequestBody Fooditem fooditem )
		{
			//1 -> product save successfully
			//0 ->error on server
			// 2 -> error while saving at database
			try {
			Fooditem p=new Fooditem();
			p.setCalories(fooditem.getCalories());
			p.setCarbohydrates(fooditem.getCarbohydrates());
			p.setProtein(fooditem.getProtein());
			p.setBadfat(fooditem.getBadfat());
			p.setFooditem_english(fooditem.getFooditem_english());
			p.setFooditem_hindi(fooditem.getFooditem_hindi());
			p.setFooditem_marathi(fooditem.getFooditem_marathi());
			p.setGoodfat(fooditem.getGoodfat());
			//byte [] imageData =file.getBytes();
			//p.setImageData(null)
			try {
			fooditemrepo.save(p);
			return 1;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return 2;
				
			}
			
			}
			catch(Exception e) {
				e.printStackTrace();
				return  0;
			}
		}
		
	   @RequestMapping("/loadRequests")
		public ArrayList<Request> loadRequests()
		{
		   // null -> error on server
		 
			ArrayList<Request> al= requestrepo.findReportedRequests();
			try {
				
			if(al.size()>=1)
			{
				return al;
			}
			else
				return al;
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
		}
		
		@RequestMapping("/login")
		public int login(@RequestBody String [] s)
		{
			// 1-> null values
			//0 -> no username
			//2 -> login successful
			//-1 -> wrong password
			//3-> error
			try
			{
				if(!(s[0]!=null && s[1]!=null))
					return 1;
				else
				{
					int count=userrepo.countByUsername(s[0]);
					if(count==0)
						return 0;
					else
					{
						User user=userrepo.findByUsername(s[0]);
						if(s[1].equals(user.getPassword()))
							return 2;
						else
							return -1;
					}
				}
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				return 3;
			}
		}
}
