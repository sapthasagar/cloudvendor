package com.sagar.restpractice.controller;

import com.sagar.restpractice.Model.CloudVendor;
import com.sagar.restpractice.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIController {
    CloudVendorService cloudVendorService;

    public CloudVendorAPIController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }
    //read a single vendor details
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        System.out.println("getCloudVendorDetails ran..");
       return cloudVendorService.getCloudVendor(vendorId);
}
    //read all the cloud vendors details
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        System.out.println("getAllCloudVendorDetails ran..");
       return cloudVendorService.getAllCloudVendors();
}   //create a new vendor with the given details
    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
        System.out.println("createCloudVendor ran..");
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Vendor creation is Successful..";
    }
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        System.out.println("updateCloudVendorDetails ran ...");
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "vendor updated successfully..";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        System.out.println("deleteCloudVendorDetails ran..");
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }
}
