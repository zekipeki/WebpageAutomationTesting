package additional;

import org.openqa.selenium.WebDriver;

public class UserPersonalInformation {

    WebDriver driver;


    private String strEmailAddress,
            firstName,
            lastName,
            password,
            company,
            address1,
            address2,
            country,
            city,
            state,
            postcode,
            other,
            mobilePhone;



    // setters

    public void setEmailAddress(String newEmailAddress){this.strEmailAddress = newEmailAddress;}
    public void setFirstName(String newFirstName){this.firstName=newFirstName;}
    public void setLastName(String newLastName){this.lastName = newLastName;}
    public void setPassword(String newPassword){this.password=newPassword;}
    public void setCompany(String newCompany){this.company=newCompany;}
    public void setAddress1(String newAddress1){this.address1=newAddress1;}
    public void setAddress2(String newAddress2){this.address2=newAddress2;}
    public void setCity(String newCity){this.city=newCity;}
    public void setState(String newState){this.state=newState;}
    public void setPostcode(String newPostcode){this.postcode=newPostcode;}
    public void setCountry(String newCountry){this.country=newCountry;}
    public void setOther(String newOther){this.other=newOther;}
    public void setMobilePhone(String newMobilePhone){this.mobilePhone=newMobilePhone;}


    //getters

    public String getEmailAddress(){return  strEmailAddress;}
    public String getFirstName(){return  firstName;}
    public String getLastName(){return lastName;}
    public String getPassword(){return password;}
    public String getCompany(){return company;}
    public String getAddress1(){return address1;}
    public String getAddress2(){return address2;}
    public String getCity(){return city;}
    public String getState(){return state;}
    public String getPostcode(){return postcode;}
    public String getCountry(){return country;}
    public String getOther(){return  other;}
    public String getMobilePhone(){return mobilePhone;}


}
