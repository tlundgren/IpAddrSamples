package com.myapplication

import inet.ipaddr.IPAddressString
import org.junit.Assert.assertEquals

/**
 * Sample code showcasing some of the capabilities of IPAddr.
 */
class IpAddrSample {
    fun ipAddressValidation() {
        // valid ip address
        var addressString = IPAddressString("192.168.1.1")
        var isIpv4 = addressString.isIPv4
        assertEquals(true, isIpv4)

        // invalid ip address
        addressString = IPAddressString("192.168.1.500")
        isIpv4 = addressString.isIPv4
        assertEquals(false, isIpv4)
    }

    fun ipAddressSubnetValidation() {
        // valid sub net
        var addressString = IPAddressString("192.168.1.1/24")
        var isIpv4 = addressString.isIPv4
        assertEquals(true, isIpv4)

        // invalid sub net
        addressString = IPAddressString("192.168.1.1/33")
        isIpv4 = addressString.isIPv4
        assertEquals(false, isIpv4)
    }

    fun subnetOverlapCheck() {
        val ipAddressSubnet = IPAddressString("192.168.1.1/24").toSequentialRange()

        // ip in sub net
        var ipAddress = IPAddressString("192.168.1.1").toAddress()
        var included = ipAddressSubnet.contains(ipAddress)
        assertEquals(true, included)

        // ip not in sub net
        ipAddress = IPAddressString("192.168.2.1").toAddress()
        included = ipAddressSubnet.contains(ipAddress)
        assertEquals(false, included)
    }
}
