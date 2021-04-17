DROP TABLE IF EXISTS subscription;

/*
   private String country;
    private String currency;
    private String locale;
    private String originPlace;
    private String destinationPlace;
    private LocalDate outboundPartialDate;
    private LocalDate inboundPartialDate;
    private Integer minPrice;
 */

CREATE TABLE subscription (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(250) NOT NULL,
    country VARCHAR(250) NOT NULL,
    currency VARCHAR(250) NOT NULL,
    locale VARCHAR(250) NOT NULL,
    origin_place VARCHAR(250) NOT NULL,
    destination_place VARCHAR(250) NOT NULL,
    outbound_partial_date DATE NOT NULL,
    inbound_partial_date DATE,
    min_price INT
);