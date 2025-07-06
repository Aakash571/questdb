package com.example.sender;

import io.questdb.client.Sender;

public class HttpUpdateExample {
    public static void main(String[] args) {
        // Configuration parameters remain the same
        try (Sender sender = Sender.fromConfig("https::addr=localhost:9000;tls_verify=unsafe_off;retry_timeout=20000;auto_flush_rows=100000;auto_flush_interval=5000;")) {

            // Simulating an update by sending new values for same symbol with new timestamp
            sender.table("trades")
                    .symbol("symbol", "ETH-USD")
                    .symbol("side", "sell")
                    .doubleColumn("price", 2630.10) // Updated price
                    .doubleColumn("amount", 0.0005) // Updated amount
                    .atNow(); // New timestamp

            sender.table("trades")
                    .symbol("symbol", "TC-USD")
                    .symbol("side", "sell")
                    .doubleColumn("price", 39500.00) // Updated price
                    .doubleColumn("amount", 0.0012)  // Updated amount
                    .atNow(); // New timestamp
        }
    }
}
