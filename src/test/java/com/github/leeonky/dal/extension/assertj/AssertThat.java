package com.github.leeonky.dal.extension.assertj;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertThat {

    @Nested
    class AssertObjectWithPureDALCode {

        @Test
        void assertion_passed() {
            DALAssert.assertThat("string").should("= 'string'");
        }

        @Test
        void assertion_failed() {
            assertThat(assertThrows(AssertionError.class,
                    () -> DALAssert.assertThat("string").should("= 'another string'")))
                    .hasMessage("= 'another string'\n" +
                            "  ^\n" +
                            "Expecting java.lang.String\n" +
                            "<string>\n" +
                            "to be equal to java.lang.String\n" +
                            "<another string>\n" +
                            "but was not\n");
        }
    }
}
