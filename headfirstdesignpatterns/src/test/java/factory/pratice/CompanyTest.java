package factory.pratice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void CompanyComputerCreateTest() {
        Company company = new LG(new LGComputerBuPoom());
        company.orderComputer("laptop");
    }

}