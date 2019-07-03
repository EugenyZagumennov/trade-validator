<#import "/parts/common.ftl" as common>

<@common.common>
    <form lang="en" method="post" enctype="multipart/form-data" action="/view">
        <label>Please, choose file with JSON</label><br>
        <input type="file" name="file" accept="application/json"/>
        <button type="submit">Load</button>
    </form>

    <#if message??>
        <span class="error">${message}</span>
    </#if>

    <#if data??>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Success</td>
                <td>Error messages</td>
            </tr>
        <#list data as d>
            <tr class=${d.isSuccess()?then("success", "fail")}>
                <td>${d.id}</td>
                <td>${d.isSuccess()?then('SUCCESS', 'FAIL')}</td>
                <td>
                    <#if d.messages??>
                        <#list d.messages as m>
                            <div>${m}</div><br>
                        </#list>
                    </#if>
                </td>
            </tr>
        </#list>
        </table>
    </#if>
</@common.common>