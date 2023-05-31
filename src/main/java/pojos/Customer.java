package pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class Customer {
        private String fullName;
        private String zip;
        private String state;
        private String streetAddress;
        private String city;

    }

