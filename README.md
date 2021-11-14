# assertj-DAL

[![travis-ci](https://travis-ci.com/leeonky/assertj-DAL.svg?branch=master)](https://travis-ci.com/github/leeonky/assertj-DAL)
[![coveralls](https://img.shields.io/coveralls/github/leeonky/assertj-DAL.svg)](https://coveralls.io/github/leeonky/assertj-DAL)
[![Lost commit](https://img.shields.io/github/last-commit/leeonky/assertj-DAL.svg)](https://github.com/leeonky/assertj-DAL)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.leeonky/assertj-DAL.svg)](https://search.maven.org/artifact/com.github.leeonky/assertj-DAL)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

use [DAL](https://github.com/leeonky/DAL-java) in assertj

## Example

```
    DALAssert.assertThat(1L).should("= 1L");
    DALAssert.expect(1L).should("= 1L");
    
    DALAssert.expect(1L).exact("1L");       // = 1L
    DALAssert.expect(1L).match("1");        // : 1
```
