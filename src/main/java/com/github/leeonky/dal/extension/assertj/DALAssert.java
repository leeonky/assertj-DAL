package com.github.leeonky.dal.extension.assertj;

import com.github.leeonky.dal.DAL;
import com.github.leeonky.dal.runtime.DalException;
import org.assertj.core.api.AbstractAssert;

public class DALAssert extends AbstractAssert<DALAssert, Object> {
    private static DAL dal = DAL.getInstance();

    public DALAssert(Object actual) {
        super(actual, DALAssert.class);
    }

    public static DALAssert assertThat(Object actual) {
        return expect(actual);
    }

    public static DALAssert expect(Object actual) {
        return new DALAssert(actual);
    }

    public static DAL getDal() {
        return dal;
    }

    public static void setDal(DAL dal) {
        DALAssert.dal = dal;
    }

    public DALAssert should(String dalCode) {
        return should("", dalCode);
    }

    private DALAssert should(String code, String dalCode) {
        String fullCode = code + dalCode;
        try {
            dal.evaluate(actual, fullCode);
        } catch (DalException dalException) {
            failWithMessage("\n%s\n%s\n", dalException.show(fullCode, code.length()), dalException.getMessage());
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
