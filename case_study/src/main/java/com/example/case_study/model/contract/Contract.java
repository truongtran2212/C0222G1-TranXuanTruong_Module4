package com.example.case_study.model.contract;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.model.employee.Employee;
import com.example.case_study.model.service.Service;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;

    private String contractStartDay;

    //    @NotEmpty(message = "Không được để trống")
    private String contractEndDay;

    @NotNull(message = "Không được để trống")
    @Min(value = 1, message = "Không được là số âm")
    private Double contractDeposit;

    @NotNull(message = "Không được để trống")
    @Min(value = 1, message = "Không được là số âm")
    private Double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @JsonBackReference(value = "employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @JsonBackReference(value = "customer")

    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @JsonBackReference(value = "service")

    private Service service;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference(value = "contract_detail_contract")
    private List<ContractDetail> contractDetail;


    // Chỉ được để int không đc để Integer
    @ColumnDefault("0")
    private int status;

    public Contract() {
    }

    public List<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(List<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Contract(Integer contractId,
                    String contractStartDay,
                    String contractEndDay,
                    Double contractDeposit,
                    Double contractTotalMoney,
                    Employee employee,
                    Customer customer,
                    Service service,
                    Integer status) {
        this.contractId = contractId;
        this.contractStartDay = contractStartDay;
        this.contractEndDay = contractEndDay;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.status = status;
    }

    public Contract(String contractStartDay,
                    String contractEndDay,
                    Double contractDeposit,
                    Double contractTotalMoney,
                    Employee employee,
                    Customer customer,
                    Service service,
                    Integer status) {
        this.contractStartDay = contractStartDay;
        this.contractEndDay = contractEndDay;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.status = status;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDay() {
        return contractStartDay;
    }

    public void setContractStartDay(String contractStartDay) {
        this.contractStartDay = contractStartDay;
    }

    public String getContractEndDay() {
        return contractEndDay;
    }

    public void setContractEndDay(String contractEndDay) {
        this.contractEndDay = contractEndDay;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;

        if (contract.getContractEndDay().equals("")) {
            errors.rejectValue("contractEndDay", "contractEndDay.invalidFormat");
        }
        if (contract.getContractStartDay().equals("")) {
            errors.rejectValue("contractStartDay", "contractStartDay.invalidFormat");
        }
        if (!contract.getContractEndDay().equals("") && !contract.getContractStartDay().equals("")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDay = LocalDate.parse(contract.getContractStartDay(), formatter);
            LocalDate endDay = LocalDate.parse(contract.getContractEndDay(), formatter);
            assert endDay != null;
            if (endDay.isBefore(startDay)) {
                errors.rejectValue("contractEndDay", "endDay.invalidFormat");
            }
        }
    }
}
