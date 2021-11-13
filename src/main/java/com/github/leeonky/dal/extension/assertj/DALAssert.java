package com.github.leeonky.dal.extension.assertj;

import com.github.leeonky.dal.DAL;
import com.github.leeonky.dal.runtime.DalException;
import org.assertj.core.api.AbstractAssert;

public class DALAssert extends AbstractAssert<DALAssert, Object> {
    public DALAssert(Object actual) {
        super(actual, DALAssert.class);
    }

    public static DALAssert assertThat(Object actual) {
        return new DALAssert(actual);
    }

    public DALAssert should(String dalCode) {
        try {
            new DAL().evaluate(actual, dalCode);
        } catch (DalException dalException) {
            failWithMessage(dalException.show(dalCode) + "\n" + dalException.getMessage() + "\n");
        }
        return this;
    }
}
