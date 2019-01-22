package GetRequest;

//RESTAssured classes import
import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.path.json.JsonPath;

import org.hamcrest.Matchers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;


//TestNG classes import
import org.testng.Assert;
import org.testng.annotations.Test;



public class GetData {
	
	@Test
	public void testResponseCode() {
		
		int code=RestAssured.get("http://www.yaddress.net/api/address").getStatusCode();
		System.out.println("status code is: '" + code + "'   ,that is standard status code for correct HTTP Request");
		Assert.assertEquals(code, 200);
		
	}

	@Test
	public void VerifyingAddressResponse(){
		
		String addressline1 = "506 4TH AVE APT 1";				//Addressline1 as GET parameters
		String addressline2 = "ASBURY PARK, NJ 07712-6086";		//Addressline2 as GET parameters
		
		Response response = RestAssured.given()
				.when()
				.get("http://www.yaddress.net/api/address?AddressLine1={addressline1}&AddressLine2={addressline2}", addressline1, addressline2);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		//getting all values and assertion
		
		//verifying ErrorCode:
		
		int Errorcode = jsonPathEvaluator.get("ErrorCode");
		
		System.out.println("Error code value:  " + Errorcode);
		Assert.assertEquals(Errorcode, 0);
		
		//verifying ErrorMessage:
		
		String errormessage= jsonPathEvaluator.get("ErrorMessage");
		System.out.println("ErrorMessage: " + errormessage);
		Assert.assertEquals(errormessage,"");			//make sure we get no error 
		
		//verifying Number:
		
		String number = jsonPathEvaluator.get("Number");
		System.out.println("Number:  " + number);
		Assert.assertNotEquals(number, ""); 			//so make sure we get value not a empty message
		
		//Verifying PreDir:
		
		String predir = jsonPathEvaluator.get("PreDir");
		System.out.println("PreDir:  " + predir);
		
		//Verifying Street:
		
		String street = jsonPathEvaluator.get("Street");
		System.out.println("Street:  " + street);
		Assert.assertNotEquals(street, "");			//add when to make sure it does not give empty value 
		
		//Verifying Suffix
		
		String suffix = jsonPathEvaluator.get("Suffix");
		System.out.println("Suffix:  " + suffix);
		Assert.assertNotEquals(suffix, "");			//add when to make sure suffix is not returned empty
		
		//Verifying PostDir
		
		String postdir = jsonPathEvaluator.get("PostDir");
		System.out.println("PostDir:  " + postdir);
		//Assert.assertNotEquals(postdir, "");		//add when to make sure the Postdir is not empty	
		
		//Verifying Sec:
		
		String sec = jsonPathEvaluator.get("Sec");
		System.out.println("Sec:  " + sec);
		Assert.assertNotEquals(sec, "");		//add when to make sure the Sec does not return empty
		
		//Verifying SecNumber:
		
		String secnumber = jsonPathEvaluator.get("SecNumber");
		System.out.println("SecNumber:  " + secnumber);
		Assert.assertNotEquals(secnumber, "");		//add when to make sure that the SecNumber does not return empty
		
		//Verifying City:
		
		String city = jsonPathEvaluator.get("City");
		System.out.println("City:  " + city);
		Assert.assertNotEquals(city, "");		//add when to make sure that the City does not return empty
		
		//Verifying State:
		
		String state = jsonPathEvaluator.get("State");
		System.out.println("State:  " + state);
		Assert.assertNotEquals(state, "");		//add when to make sure that State does not return empty
		
		//Verifying Zip
		
		String zip = jsonPathEvaluator.get("Zip");
		System.out.println("Zip:  " + zip);
		Assert.assertNotEquals(zip, "");		//add when to make sure that Zip does not return empty
		
		//Verifying Zip4
		
		String zip4 = jsonPathEvaluator.get("Zip4");
		System.out.println("Zip4:  " + zip4);
		Assert.assertNotEquals(zip4, "");		//add when to make sure that Zip4 does not return empty
		
		//Verifying County
		
		String county = jsonPathEvaluator.get("County");
		System.out.println("County:  " + county);
		Assert.assertNotEquals(county, "");		//add when to make sure that County does not return empty
		
		//Verifying StateFP
		
		String statefp = jsonPathEvaluator.get("StateFP");
		System.out.println("StateFP:  " + statefp);
		Assert.assertNotEquals(statefp, "");		//add when to make sure that StateFP does not return empty
		
		//Verifying CountyFP
		
		String countyfp = jsonPathEvaluator.get("CountyFP");
		System.out.println("CountyFP:  " + countyfp);
		Assert.assertNotEquals(countyfp, "");		//add when to make sure that CountyFP does not return empty
		
		//Verifying CensusTract
		
		String censustract = jsonPathEvaluator.get("CensusTract");
		System.out.println("CensusTract:  " + censustract);
		Assert.assertNotEquals(censustract, "");		//add when to make sure that CensusTract does not return empty
		
		//Verifying CensusBlock
		
		String censusblock = jsonPathEvaluator.get("CensusBlock");
		System.out.println("CensusBlock:  " + censusblock);
		Assert.assertNotEquals(censusblock, "");		//add when to make sure that CensusBlock does not return empty
		
		//Verifying Latitude
		
		float latitude = jsonPathEvaluator.get("Latitude");
		System.out.println("Latitude:  " + latitude);
		Assert.assertNotEquals(latitude, "");		//add when to make sure that Latitude does not return empty
		
		//Verifying Longitude
		
		float longitude = jsonPathEvaluator.get("Longitude");
		System.out.println("Longitude:  " + longitude);
		Assert.assertNotEquals(longitude, "");		//add when to make sure that Longitude does not return empty
		
		//Verifying GeoPrecision
		
		int geoprecision = jsonPathEvaluator.get("GeoPrecision");
		System.out.println("GeoPrecision:  " + geoprecision);
		Assert.assertNotEquals(geoprecision, "");		//add when to make sure that GeoPrecision does not return empty
		
		

	}
		
}



