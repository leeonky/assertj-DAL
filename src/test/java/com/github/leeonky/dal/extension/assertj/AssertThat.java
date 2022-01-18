package com.github.leeonky.dal.extension.assertj;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.github.leeonky.dal.extension.assertj.DALAssert.expect;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertThat {

    @Nested
    class AssertObjectWithPureDALCode {

        @Test
        void assertion_passed() {
            DALAssert.assertThat("string").should("= 'string'");
            expect("string").should("= 'string'");
        }

        @Test
        void assertion_failed() {
            assertThat(assertThrows(AssertionError.class,
                    () -> DALAssert.assertThat("string").should("= 'another string'")))
                    .hasMessage("\n= 'another string'\n" +
                            "  ^\n" +
                            "Expecting java.lang.String\n" +
                            "<string>\n" +
                            "to be equal to java.lang.String\n" +
                            "<another string>\n" +
                            "but was not\n");
        }
    }

    @Nested
    class AssertEquals {

        @Test
        void assertion_passed() {
            DALAssert.assertThat("string").exact("'string'");
        }

        @Test
        void assertion_failed() {
            assertThat(assertThrows(AssertionError.class,
                    () -> DALAssert.assertThat("string").exact("'another string'")))
                    .hasMessage("\n'another string'\n" +
                            "^\n" +
                            "Expecting java.lang.String\n" +
                            "<string>\n" +
                            "to be equal to java.lang.String\n" +
                            "<another string>\n" +
                            "but was not\n");
        }
    }

    @Nested
    class AssertMatches {

        @Test
        void assertion_passed() {
            DALAssert.assertThat(1L).match("1");
            expect(1L).match("1");
        }

        @Test
        void assertion_failed() {
            assertThat(assertThrows(AssertionError.class,
                    () -> DALAssert.assertThat(2).match("/1/")))
                    .hasMessage("\n/1/\n" +
                            "^\n" +
                            "Expecting java.lang.Integer\n" +
                            "<2>\n" +
                            "to match /1/ but was not\n");
        }
    }
}
