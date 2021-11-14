package com.github.leeonky.dal.extension.assertj;

import com.github.leeonky.dal.DAL;
import com.github.leeonky.dal.runtime.DalException;
import org.assertj.core.api.AbstractAssert;

public class DALAssert extends AbstractAssert<DALAssert, Object> {
    public DALAssert(Object actual) {
        super(actual, DALAssert.class);
    }

    public static DALAssert assertThat(Object actual) {
        return expect(actual);
    }

    public static DALAssert expect(Object actual) {
        return new DALAssert(actual);
    }

    public DALAssert should(String dalCode) {
        return should("", dalCode);
    }

    private DALAssert should(String code, String dalCode) {
        String fullCode = code + dalCode;
        try {
            new DAL().evaluate(actual, fullCode);
        } catch (DalException dalException) {
            failWithMessage(dalException.show(fullCode, code.length()) + "\n" + dalException.getMessage() + "\n");
        }
        return this;
    }

    public DALAssert exact(String dalCode) {
        return should("=", dalCode);
    }

    public DALAssert match(String dalCode) {
        return should(":", dalCode);
    }
}
