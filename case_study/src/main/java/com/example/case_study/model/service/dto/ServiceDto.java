package com.example.case_study.model.service.dto;

import com.example.case_study.model.service.RentType;
import com.example.case_study.model.service.ServiceType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ServiceDto {
    private Integer serviceId;

    @Pattern(regexp = "^DV-[0-9]{4}$", message = "Sai định dạng và không được để trống")
    private String serviceCode;

    @NotBlank(message = "Không được để trống")
    private String serviceName;

//    @Pattern(regexp = "^[0-9]+$", message = "Phải nhập số")
    @Min(value = 1, message = "Không được nhỏ hơn 1")
    private Integer serviceArea;

    @Min(value = 1, message = "Không được nhỏ hơn 1")
    private Double serviceCost;

    @Min(value = 1, message = "Không được nhỏ hơn 1")
    private Integer serviceMaxPeople;

    @NotBlank(message = "Không được để trống")
    private String standardRoom;

    @NotBlank(message = "Không được để trống")
    private String descriptionOtherConvenience;

    @Min(value = 1, message = "Không được nhỏ hơn 1")
    private Double poolArea;

    @Min(value = 1, message = "Không được nhỏ hơn 1")
    private Integer numberOfFloors;


    private RentType rentType;

    private ServiceType serviceType;

    public ServiceDto() {
    }

    public ServiceDto(Integer serviceId,
                      @Pattern(regexp = "^DV-[0-9]{4}$", message = "Sai định dạng và không được để trống") String serviceCode,
                      @NotBlank(message = "Không được để trống") String serviceName,
                      @Min(value = 1, message = "Không được nhỏ hơn 1") Integer serviceArea,
                      @Min(value = 1, message = "Không được nhỏ hơn 1") Double serviceCost,
                      @Min(value = 1, message = "Không được nhỏ hơn 1") Integer serviceMaxPeople,
                      @NotBlank(message = "Không được để trống") String standardRoom,
                      @NotBlank(message = "Không được để trống") String descriptionOtherConvenience,
                      @Min(value = 1, message = "Không được nhỏ hơn 1") Double poolArea,
                      @Min(value = 1, message = "Không được nhỏ hơn 1") Integer numberOfFloors,
                      RentType rentType,
                     ServiceType serviceType) {
        this.serviceId = serviceId;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }
}
