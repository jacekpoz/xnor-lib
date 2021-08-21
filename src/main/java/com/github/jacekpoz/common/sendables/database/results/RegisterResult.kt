package com.github.jacekpoz.common.sendables.database.results

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.sendables.database.queries.basequeries.UserQuery
import com.github.jacekpoz.common.EnumResults.Register

import java.sql.SQLException

class RegisterResult @JsonCreator constructor(
    @JsonProperty("query") uq: UserQuery?,
) : UserResult(uq!!) {

    @JsonProperty("result")
    var result: Register = Register.DEFAULT

    @JsonProperty("ex")
    var ex: SQLException = SQLException()
}