import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by TheWoz on 9/16/14.
 */
public class DataConverter {
    public static void main(String args[]) {
        try {
            Scanner customer = new Scanner(new BufferedReader(new FileReader("data/Customers.dat")));
            Scanner persons = new Scanner(new BufferedReader(new FileReader("data/Persons.dat")));
            Scanner products = new Scanner(new BufferedReader(new FileReader("data/Products.dat")));

            int customerSize = customer.nextInt();
            int personsSize = persons.nextInt();
            int productsSize = products.nextInt();

            String customerArray[] = new String[9];
            String personsArray[] = new String[personsSize];
            String productsArray[] = new String[productsSize];
            Customer butters[] = new Customer[customerSize];

            int i = 0;

            while(customer.hasNextLine()){
                String array[] = new String[5];
                char[] arr = customer.nextLine().toCharArray();
                String blah = "";
                int k = 0;
                for(int j=0; j<arr.length; j++) {
                    if(" ".equals(String.valueOf(arr[j])) && String.valueOf(arr[j-1]).equals(";")) {

                    } else if(";".equals(String.valueOf(arr[j])) || j == arr.length-1 ) {
                            array[k] = blah;
                            blah = "";
                            System.out.println(array[k]);
                            k++;
                    } else {
                        blah = blah + String.valueOf(arr[j]);
                    }

                }
                String code = array[0];
                String type = array[1];
                String pCode = array[2];
                String name = array[3];
                String address = array[4];
                Customer c = new Customer(code, type, pCode, name, address);
                c.setCustomerCode(code);
                c.setCustomerType(type);
                c.setPrimaryCode(pCode);
                c.setName(name);
                c.setAddress(address);
                butters[i] = c;
                i++;
            }
            Gson gson = new GsonBuilder().create();
            for(int a=0; a<customerSize; a++) {

            }
//                for(int j=0; j<; j++) {
//                    int k = 0;
//                    if(arr[j] == scrotum.charAt(0)) {
//                        array[k] = balls;
//                        balls = "";
//                    } else {
//                        balls = balls + String.valueOf(arr[j]);
//                    }
//                }

//            for(int i=0; i < customerSize; i++) {
//                String split[] = customerArray[i].split(";");
//                String code = split[0];
//                String type = split[1];
//                String pCode = split[2];
//                String name = split[3];
//                String address = split[4];
//                System.out.print(code + type + pCode + name + address);
//            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
//        int customerSize = customer.nextInt();
//        int personsSize = persons.nextInt();
//        int productsSize = products.nextInt();
//
//        String customerArray[] = new String[customerSize];
//        String personsArray[] = new String[personsSize];
//        String productsArray[] = new String[productsSize];
//        ArrayList<String> customerSplit = new ArrayList<String>();
//
//        while(customer.hasNext()){
//            int i = 0;
//            customerArray[i] = customer.nextLine();
//        }
//        while(persons.hasNext()) {
//            int i = 0;
//            personsArray[i] = persons.nextLine();
//            i++;
//        }
//
//        while(products.hasNext()) {
//            int i = 0;
//            productsArray[i] = customer.next();
//            i++;
//        }
//        for(int i=0; i < customerSize; i++) {
//            String split[] = customerArray[i].split(";");
//            String code = split[0];
//            String type = split[1];
//            String pCode = split[2];
//            String name = split[3];
//            String address = split[4];
//            System.out.print(code + type + pCode + name + address);
//            while(customerArray[i].matches(";")) {
//
//                customerSplit.set()= customerArray[i];
//                j++;
//            }
        }


}
class Address {
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private String country;

    public Address(String street, String city, String state, Integer zip, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZip(Integer zip) {
        this.zip = zip;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String wholeAddressLine() {
        return this.street + "," + this.city + "," + this.state + "," + this.zip + "," + this.country;
    }
}

class Name {
    private String firstName;
    private String lastName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFullName() {
        return this.lastName + ", " + this.firstName;
    }
}
class Persons {
    private String personCode;
    private String name;
    private Address address;
    private String emailAddress;

    public Persons(String personCode, String name, Address address, String emailAddress) {
        this.personCode = personCode;
        this.name = name;
        this.address = address;
        this.emailAddress = emailAddress;
    }

}

class Customer {
    private String customerCode;
    private String customerType;
    private String primaryCode;
    private String name;
    private String address;

    public Customer(String customerCode, String type, String primaryCode, String name, String address) {
        this.customerCode = customerCode;
        this.customerType = type;
        this.primaryCode = primaryCode;
        this.name = name;
        this.address = address;
    }
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    public void setPrimaryCode(String primaryCode) {
        this.primaryCode = primaryCode;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCustomerCode() {
        return this.customerCode;
    }
    public String getCustomerType() {
        return this.customerType;
    }
    public String getPrimaryCode() {
        return this.primaryCode;
    }
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
}

class Product {
    private String code;
    private String type;
    private String name;

    public void setCode(String code) {
        this.code = code;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return this.code;
    }
    public String getType() {
        return this.type;
    }
    public String getName(String code) {
        return this.name;
    }

    public class Equipment {
        private String code;
        private String type;
        private String name;
        private Double pricePerUnit;


        public Equipment (String code, String type, String name, Double pricePerUnit) {
            this.code = code;
            this.type = type;
            this.name = name;
            this.pricePerUnit = pricePerUnit;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public void setType(String type) {
            this.type = type;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setPricePerUnit(Double sPricePerUnit) {
            this.pricePerUnit = sPricePerUnit;
        }
        public String getCode() {
            return this.code;
        }
        public String getType() {
            return this.type;
        }
        public String getName(String code) {
            return this.name;
        }
        public Double getPricePerUnit() {
            return this.pricePerUnit;
        }

    }
    public class Licenses {
        private String code;
        private String type;
        private String name;
        private Double serviceFee;
        private Double annualLicenseFee;

        public Licenses(String code, String type, String name, Double serviceFee, Double annualLicenseFee) {
            this.code = code;
            this.type = type;
            this.name = name;
            this.serviceFee = serviceFee;
            this.annualLicenseFee = annualLicenseFee;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public void setType(String type) {
            this.type = type;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setServiceFee(Double serviceFee) {
            this.serviceFee = serviceFee;
        }
        public void setAnnualLicenseFee(Double annualLicenseFee) {
            this.annualLicenseFee = annualLicenseFee;
        }
        public String getCode() {
            return this.code;
        }
        public String getType() {
            return this.type;
        }
        public String getName(String code) {
            return this.name;
        }
        public Double getServiceFee() {
            return this.serviceFee;
        }
        public Double getAnnualLicenseFee() {
            return this.annualLicenseFee;
        }

    }

    public class Consultations {
        private String code;
        private String type;
        private String name;
        private String consultantPersonCode;
        private Double hourlyFee;

        public Consultations(String code, String type, String name, String consultantPersonCode, Double hourlyFee) {
            this.code = code;
            this.type = type;
            this.name = name;
            this.consultantPersonCode = consultantPersonCode;
            this.hourlyFee =hourlyFee;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public void setType(String type) {
            this.type = type;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setConsultantPersonCode(String consultantPersonCode) {
            this.consultantPersonCode = consultantPersonCode;
        }
        public void setHourlyfee(Double hourlyFee) {
            this.hourlyFee = hourlyFee;
        }
        public String getCode() {
            return this.code;
        }
        public String getType() {
            return this.type;
        }
        public String getName(String code) {
            return this.name;
        }
        public String getConsultantPersonCode() {
            return this.consultantPersonCode;
        }
        public Double getHourlyFee() {
            return this.hourlyFee;
        }

    }
}
