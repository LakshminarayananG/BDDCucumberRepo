package com.test.lakshmi.selenium.pagelocators;

import org.openqa.selenium.By;

import com.test.lakshmi.selenium.framework.GenericWrapperFunctions;

public class OrderConfirmation extends GenericWrapperFunctions {

	public final By megaMenuTshirt = By.xpath("//div[@id='block_top_menu']/ul/li/a[@Title='T-shirts']");
	
	
	// plp
	public final By btnAddToCart = By.xpath("//a[@Title='Add to cart']");
	public final By plpProductPrice = By.xpath("//span[@class='price product-price']");
	public final By plpProductImage = By.xpath("//div[@class='product-image-container']");
	
	
	
	// add to cart pop up	
	public final By cartShippingCost = By.cssSelector("span[class='ajax_cart_shipping_cost']");
	public final By productName = By.id("layer_cart_product_title");
	public final By cartTotalPrice = By.cssSelector("span[class='ajax_block_cart_total']");
	public final By btnProceedToCheckOut = By.xpath("//a[@title='Proceed to checkout']");
	public final By productQuantity = By.id("layer_cart_product_quantity");
	public final By cartProductPrice = By.cssSelector(".ajax_block_products_total");

	
	
	// summary Page	
	public final By btnSummaryProceedToCheckOut = By
			.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");
	public final By summaryProductPrice = By.id("total_product");
	public final By summaryShippingCost = By.id("total_shipping");
	public final By summaryTotalPriceWithTax = By.id("total_price");
	public final By confirmationTotalAmount = By.id("amount");
	public final By btnOrderConfirmation = By.xpath("//p[@id='cart_navigation']/button[@type='submit']");
	public final By btnAddressProceedToCheckOut = By.xpath("//button[@name='processAddress']");
	public final By checkBoxTermsOfService = By.xpath("//input[@type='checkbox']");
	public final By btnShippingConfirmation = By.xpath("//button[@name='processCarrier']");
	public final By paymentMode = By.cssSelector(".bankwire");
	public final By orderReferenceNumber = By.xpath("//div[@class='box']");

}
