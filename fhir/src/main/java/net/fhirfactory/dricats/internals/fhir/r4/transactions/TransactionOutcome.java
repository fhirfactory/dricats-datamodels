package net.fhirfactory.dricats.internals.fhir.r4.transactions;

import java.io.Serializable;
import java.time.Instant;

import org.hl7.fhir.r4.model.OperationOutcome;

import com.fasterxml.jackson.annotation.JsonFormat;

import ca.uhn.fhir.rest.api.MethodOutcome;
import net.fhirfactory.dricats.model.component.datatypes.ComponentId;
import net.fhirfactory.dricats.model.constants.DeploymentPropertyConstants;

public class TransactionOutcome implements Serializable {
	private MethodOutcome methodOutcome;
	private OperationOutcome operationOutcome;
	private ComponentId serverId;
	private ComponentId clientId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
	private Instant transactionStart;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = DeploymentPropertyConstants.DEFAULT_TIMEZONE)
	private Instant transactionFinish;

	//
	// Constructor(s)
	//

	public TransactionOutcome() {
		this.methodOutcome = null;
		this.operationOutcome = null;
		this.serverId = null;
		this.clientId = null;
		this.transactionStart = null;
		this.transactionFinish = null;
	}

	//
	// Getters and Setters
	//

	/**
	 * @return the methodOutcome
	 */
	public MethodOutcome getMethodOutcome() {
		return methodOutcome;
	}

	/**
	 * @param methodOutcome the methodOutcome to set
	 */
	public void setMethodOutcome(MethodOutcome methodOutcome) {
		this.methodOutcome = methodOutcome;
	}

	/**
	 * @return the operationOutcome
	 */
	public OperationOutcome getOperationOutcome() {
		return operationOutcome;
	}

	/**
	 * @param operationOutcome the operationOutcome to set
	 */
	public void setOperationOutcome(OperationOutcome operationOutcome) {
		this.operationOutcome = operationOutcome;
	}

	/**
	 * @return the serverId
	 */
	public ComponentId getServerId() {
		return serverId;
	}

	/**
	 * @param serverId the serverId to set
	 */
	public void setServerId(ComponentId serverId) {
		this.serverId = serverId;
	}

	/**
	 * @return the clientId
	 */
	public ComponentId getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(ComponentId clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the transactionStart
	 */
	public Instant getTransactionStart() {
		return transactionStart;
	}

	/**
	 * @param transactionStart the transactionStart to set
	 */
	public void setTransactionStart(Instant transactionStart) {
		this.transactionStart = transactionStart;
	}

	/**
	 * @return the transactionFinish
	 */
	public Instant getTransactionFinish() {
		return transactionFinish;
	}

	/**
	 * @param transactionFinish the transactionFinish to set
	 */
	public void setTransactionFinish(Instant transactionFinish) {
		this.transactionFinish = transactionFinish;
	}

	//
	// toString()
	//

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionOutcome {");
		builder.append("methodOutcome=").append(methodOutcome);
		builder.append(", operationOutcome=").append(operationOutcome);
		builder.append(", serverId=").append(serverId);
		builder.append(", clientId=").append(clientId);
		builder.append(", transactionStart=").append(transactionStart);
		builder.append(", transactionFinish=").append(transactionFinish);
		builder.append("}");
		return builder.toString();
	}

}
