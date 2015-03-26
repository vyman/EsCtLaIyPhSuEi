
<html>
<form action="https://test.payu.in/_payment" method="post" name="payuForm">
	  <input type="hidden" name="key" value="${merchant_key}" />
      <input type="hidden" name="hash" value="${hash}"/>
      <input type="hidden" name="txnid" value="${txnid}" />
	  <input type="hidden" name="service_provider" value="payu_paisa" />
      <table>
        <tr>
          <td><b>Mandatory Parameters</b></td>
        </tr>
        <tr>
          <td>Amount: </td>
          <td><input name="amount" /></td>
          <td>First Name: </td>
          <td><input name="firstname" id="firstname" value="${firstName}" /></td>
        </tr>
        <tr>
          <td>Email: </td>
          <td><input name="email" id="email"  /></td>
          <td>Phone: </td>
          <td><input name="phone" /></td>
        </tr>
        <tr>
          <td>Product Info: </td>
          <td colspan="3"><input name="productinfo" size="64" /></td>
        </tr>
         <tr>
          <td>Success URI: </td>
          <td colspan="3"><input name="surl" value="http://localhost:7001/StayEclipse/Payment/Success" size="64" /></td>
        </tr>
        <tr>
          <td>Failure URI: </td>
          <td colspan="3"><input name="furl" value="http://localhost:7001/StayEclipse/Payment/Failure" size="64" /></td>
        </tr>
        <tr>
          <td><b>Optional Parameters</b></td>
        </tr>
       <tr>
          <td>Last Name: </td>
          <td><input name="lastname" id="lastname"  /></td>
          <td>Cancel URI: </td>
          <td><input name="curl" value="" /></td>
        </tr>
        <tr>
          <td>Address1: </td>
          <td><input name="address1"  /></td>
          <td>Address2: </td>
          <td><input name="address2"  /></td>
        </tr>
        <tr>
          <td>City: </td>
          <td><input name="city"  /></td>
          <td>State: </td>
          <td><input name="state"  /></td>
        </tr>
        <tr>
          <td>Country: </td>
          <td><input name="country"  /></td>
          <td>Zipcode: </td>
          <td><input name="zipcode"  /></td>
        </tr>
        
        <tr>
          <td>PG: </td>
          <td><input name="pg"  /></td>
        </tr>
        <tr>
          <td colspan="4"><input type="submit" value="Submit" /></td>
        </tr>
      </table>
    </form>


</body>
</html>