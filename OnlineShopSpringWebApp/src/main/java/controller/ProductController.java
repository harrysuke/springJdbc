package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Product;
import service.ProductDao_usingJdbcTemplate;

@Controller
@RequestMapping("/product")
public class ProductController {

	final private ProductDao_usingJdbcTemplate productDao;
	
	@Autowired
	public ProductController(ProductDao_usingJdbcTemplate productDao) {
		this.productDao = productDao;
	}

	@GetMapping("/getall")
	@ResponseBody
	public String getall(Model model) {
		List<Product> productList = productDao.getall();
		model.addAttribute("productList", productList);
		//just return responsebody for simplicity... pls change to return the appropriate jsp view page here
		return "getall : " +productList.toString();
		//return "listofallproducts";
	}
	
	@GetMapping("/getall_mav")
	public ModelAndView getall_mav() {
		List<Product> productList = productDao.getall();
		ModelAndView mav = new ModelAndView("listofallproducts");
		mav.addObject("productList", productList);
		return mav;
	}

	@GetMapping("/getbyid/{id}")
	@ResponseBody
	public String getbyid(@PathVariable int id, Model model) {
		Product p = productDao.getProductById(id);
		model.addAttribute("product", p);
		return "Product Detail Info : "+p.toString();
	}

	// complete the handling of all possible request patterns here, ie pattern to ask for page+form to insert new product,
	//pattern to serve the post request to insert product
	//request pattern to update, delete etc
	
//	@PostMapping("/add") @PostMapping is more suitable - to handle the post request - form submit
	@PostMapping("/add")
	public String add(@ModelAttribute("product") Product product, Model model) {
		model.addAttribute("product",product);
		int numofRowAffected = productDao.createProduct(product);
		//return "added ... :"+product.toString()+" : RowAffected : "+numofRowAffected;
		return "redirect:/product/list";
	}
	
	@GetMapping("/addForm")
	public String showAddProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "formaddproduct";
	}
	@GetMapping("/getAllProduct")
	public ModelAndView getAllProduct() {
	    List<Product> productList = productDao.getAll();
	    ModelAndView modelAndView = new ModelAndView("listofallproducts");
	    modelAndView.addObject("productList", productList);
	    return modelAndView;
	}
	@RequestMapping("/list")
	public String getAllProducts(Model model) {
	    List<Product> productList = productDao.getall();
	    model.addAttribute("productList", productList);
	    return "listofallproducts";
	}
	
	@GetMapping("/id/{id}")
	public String getId(@PathVariable int id, Model model) {
		Product product = productDao.getProductById(id);
		model.addAttribute("product", product);
		return "productdetailinfo";
	}
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable int id, Model model) {
		Product product = productDao.getProductById(id);
		model.addAttribute("product", product);
		return "formeditproduct";
	}
	@PostMapping("/update")
	public String updateProduct(@ModelAttribute("product") Product product) {
		int rowAffected = productDao.updateProduct(product);
		return "redirect:/product/list";
	}
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		productDao.deleteProduct(id);
		return "redirect:/product/list";
	}
	@GetMapping("/search")
    public String searchProducts(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        if (keyword != null && !keyword.isEmpty()) {
            List<Product> searchResults = productDao.searchProducts(keyword);
            model.addAttribute("searchResults", searchResults);
        }
        return "searchresults"; // Assuming you have a searchresults.jsp page
    }
}
