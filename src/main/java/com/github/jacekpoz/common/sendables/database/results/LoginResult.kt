package com.github.jacekpoz.common.sendables.database.results

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.jacekpoz.common.EnumResults.Login
import com.github.jacekpoz.common.sendables.database.queries.UserQuery

import java.sql.SQLException

class LoginResult @JsonCreator constructor(
    @JsonProperty("query") lq: UserQuery,
) : UserResult(lq) {

    @JsonProperty("result")
    var result: Login = Login.DEFAULT

    @JsonProperty("ex")
    var ex: SQLException = SQLException()
}