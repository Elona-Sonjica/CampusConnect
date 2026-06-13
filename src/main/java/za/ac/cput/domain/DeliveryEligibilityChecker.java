package za.ac.cput.domain;

import java.util.List;

public class DeliveryEligibilityChecker {
    private Long checkerId;
    private List<String> eligibleResidences;
    private List<String> eligiblePrivateAccommodations;
    private double maxDeliveryRadiusKm;

    protected DeliveryEligibilityChecker() {}

    private DeliveryEligibilityChecker(Builder builder) {
        this.checkerId = builder.checkerId;
        this.eligibleResidences = builder.eligibleResidences;
        this.eligiblePrivateAccommodations = builder.eligiblePrivateAccommodations;
        this.maxDeliveryRadiusKm = builder.maxDeliveryRadiusKm;
    }

    // Getters
    public Long getCheckerId() { return checkerId; }
    public List<String> getEligibleResidences() { return eligibleResidences; }
    public List<String> getEligiblePrivateAccommodations() { return eligiblePrivateAccommodations; }
    public double getMaxDeliveryRadiusKm() { return maxDeliveryRadiusKm; }

    public DeliveryEligibility checkStudentEligibility(Student student) {
        if (student == null) {
            return DeliveryEligibility.NOT_ELIGIBLE;
        }

        // Check if student lives in eligible residence
        if (student.getAccommodationType() == AccommodationType.CPUT_RESIDENCE) {
            if (eligibleResidences != null && eligibleResidences.contains(student.getRegisteredAddress())) {
                return DeliveryEligibility.CPUT_RESIDENCE;
            }
        }

        // Check if student lives in eligible private accommodation
        if (student.getAccommodationType() == AccommodationType.REGISTERED_ACCOMMODATION) {
            if (eligiblePrivateAccommodations != null &&
                    eligiblePrivateAccommodations.contains(student.getRegisteredAddress())) {
                return DeliveryEligibility.CPUT_RESIDENCE;
            }
        }

        return DeliveryEligibility.NOT_ELIGIBLE;
    }

    public DeliveryEligibility checkAddressEligibility(Address address, Location campusLocation) {
        if (address == null || campusLocation == null) {
            return DeliveryEligibility.NOT_ELIGIBLE;
        }

        Location addressLocation = new Location.Builder()
                .setAddress(address.getFullAddress())
                .build();

        if (addressLocation.isWithinRadius(campusLocation, maxDeliveryRadiusKm)) {
            return DeliveryEligibility.CPUT_RESIDENCE;
        }

        return DeliveryEligibility.NOT_ELIGIBLE;
    }

    @Override
    public String toString() {
        return "DeliveryEligibilityChecker{" +
                "checkerId=" + checkerId +
                ", maxDeliveryRadiusKm=" + maxDeliveryRadiusKm +
                '}';
    }

    public static class Builder {
        private Long checkerId;
        private List<String> eligibleResidences;
        private List<String> eligiblePrivateAccommodations;
        private double maxDeliveryRadiusKm;

        public Builder setCheckerId(Long checkerId) { this.checkerId = checkerId; return this; }
        public Builder setEligibleResidences(List<String> eligibleResidences) { this.eligibleResidences = eligibleResidences; return this; }
        public Builder setEligiblePrivateAccommodations(List<String> eligiblePrivateAccommodations) {
            this.eligiblePrivateAccommodations = eligiblePrivateAccommodations;
            return this;
        }
        public Builder setMaxDeliveryRadiusKm(double maxDeliveryRadiusKm) { this.maxDeliveryRadiusKm = maxDeliveryRadiusKm; return this; }

        public DeliveryEligibilityChecker build() { return new DeliveryEligibilityChecker(this); }
    }
}
