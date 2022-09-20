/*
 * Copyright (c) 2021 Mark A. Hunter (ACT Health)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.fhirfactory.dricats.model.configuration.filebased.archetypes.common;

import net.fhirfactory.dricats.model.configuration.filebased.segments.ApplicationDebugSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.JavaDeploymentSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.LoadBalancerSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.SecurityCredentialSegment;
import net.fhirfactory.dricats.model.configuration.filebased.segments.endpoints.http.HTTPServerEndpointSegment;

public abstract class WildflyBasedServerPropertyFile extends BaseSubsystemPropertyFile {

    private ApplicationDebugSegment debugProperties;
    private SecurityCredentialSegment hapiAPIKey;
    private JavaDeploymentSegment javaDeploymentParameters;
    private HTTPServerEndpointSegment kubeReadinessProbe;
    private HTTPServerEndpointSegment kubeLivelinessProbe;
    private HTTPServerEndpointSegment prometheusPort;
    private HTTPServerEndpointSegment jolokiaPort;
    private LoadBalancerSegment loadBalancer;

    //
    // Constructor(s)
    //

    public WildflyBasedServerPropertyFile() {
            super();
            loadBalancer = new LoadBalancerSegment();
            debugProperties = new ApplicationDebugSegment();
            hapiAPIKey = new SecurityCredentialSegment();
            javaDeploymentParameters = new JavaDeploymentSegment();
            this.kubeLivelinessProbe = new HTTPServerEndpointSegment();
            this.kubeReadinessProbe = new HTTPServerEndpointSegment();
            this.jolokiaPort = new HTTPServerEndpointSegment();
            this.prometheusPort = new HTTPServerEndpointSegment();
    }

    //
    // Getters and Setters
    //

    public HTTPServerEndpointSegment getKubeReadinessProbe() {
        return kubeReadinessProbe;
    }

    public void setKubeReadinessProbe(HTTPServerEndpointSegment kubeReadinessProbe) {
        this.kubeReadinessProbe = kubeReadinessProbe;
    }

    public HTTPServerEndpointSegment getKubeLivelinessProbe() {
        return kubeLivelinessProbe;
    }

    public void setKubeLivelinessProbe(HTTPServerEndpointSegment kubeLivelinessProbe) {
        this.kubeLivelinessProbe = kubeLivelinessProbe;
    }

    public HTTPServerEndpointSegment getPrometheusPort() {
        return prometheusPort;
    }

    public void setPrometheusPort(HTTPServerEndpointSegment prometheusPort) {
        this.prometheusPort = prometheusPort;
    }

    public HTTPServerEndpointSegment getJolokiaPort() {
        return jolokiaPort;
    }

    public void setJolokiaPort(HTTPServerEndpointSegment jolokiaPort) {
        this.jolokiaPort = jolokiaPort;
    }
        
    public LoadBalancerSegment getLoadBalancer() {
            return loadBalancer;
    }

    public void setLoadBalancer(LoadBalancerSegment loadBalancer) {
            this.loadBalancer = loadBalancer;
    }

    public ApplicationDebugSegment getDebugProperties() {
            return debugProperties;
    }

    public void setDebugProperties(ApplicationDebugSegment debugProperties) {
            this.debugProperties = debugProperties;
    }

    public SecurityCredentialSegment getHapiAPIKey() {
            return hapiAPIKey;
    }

    public void setHapiAPIKey(SecurityCredentialSegment hapiAPIKey) {
            this.hapiAPIKey = hapiAPIKey;
    }

    public JavaDeploymentSegment getJavaDeploymentParameters() {
            return javaDeploymentParameters;
    }

    public void setJavaDeploymentParameters(JavaDeploymentSegment javaDeploymentParameters) {
            this.javaDeploymentParameters = javaDeploymentParameters;
    }
    
    //
    // toString
    //

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClusterServiceDeliverySubsystemPropertyFile{");
        sb.append("debugProperties=").append(debugProperties);
        sb.append(", hapiAPIKey=").append(hapiAPIKey);
        sb.append(", javaDeploymentParameters=").append(javaDeploymentParameters);
        sb.append(", kubeReadinessProbe=").append(kubeReadinessProbe);
        sb.append(", kubeLivelinessProbe=").append(kubeLivelinessProbe);
        sb.append(", prometheusPort=").append(prometheusPort);
        sb.append(", jolokiaPort=").append(jolokiaPort);
        sb.append(", loadBalancer=").append(loadBalancer);
        sb.append('}');
        return sb.toString();
    }

    
}
