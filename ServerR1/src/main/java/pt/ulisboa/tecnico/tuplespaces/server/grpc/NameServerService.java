package pt.ulisboa.tecnico.tuplespaces.server.grpc;

import static pt.ulisboa.tecnico.tuplespaces.server.ServerMain.debug;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import pt.ulisboa.tecnico.tuplespaces.nameserver.contract.NameServerGrpc;
import pt.ulisboa.tecnico.tuplespaces.nameserver.contract.NameServerOuterClass;
import pt.ulisboa.tecnico.tuplespaces.server.grpc.exceptions.NameServerRPCFailureException;

public class NameServerService {
  private final String address;
  private ManagedChannel channel;
  private NameServerGrpc.NameServerBlockingStub stub;

  public NameServerService(String address) {
    this.address = address;
  }

  public void connect() {
    debug("Call NameServerService.connect: No arguments");
    this.channel = ManagedChannelBuilder.forTarget(this.address).usePlaintext().build();
    this.stub = NameServerGrpc.newBlockingStub(this.channel);
  }

  public void shutdown() {
    debug("Call NameServerService.shutdown: No arguments");
    if (channel != null) this.channel.shutdown();
  }

  /**
   * NameServer service 'register' gRPC wrapper.
   *
   * @param serviceName procedure ServiceName argument
   * @param qualifier   procedure Qualifier argument
   * @param address     procedure Address argument
   * @throws NameServerRPCFailureException on RPC failure
   */
  public void register(String serviceName, String qualifier, String address)
      throws NameServerRPCFailureException {
    debug(
        String.format(
            "Call NameServerService.register: serviceName=%s, qualifier=%s, address=%s",
            serviceName, qualifier, address));
    try {
      stub.register(
          NameServerOuterClass.RegisterRequest.newBuilder()
              .setServiceName(serviceName)
              .setQualifier(qualifier)
              .setAddress(address)
              .build());
    } catch (StatusRuntimeException e) {
      throw new NameServerRPCFailureException("Register", e.getStatus().getDescription());
    }
  }

  /**
   * NameServer service 'delete' gRPC wrapper.
   *
   * @param serviceName procedure ServiceName argument
   * @param address     procedure Address argument
   * @throws NameServerRPCFailureException on RPC failure
   */
  public void delete(String serviceName, String address) throws NameServerRPCFailureException {
    debug(
            String.format(
                    "Call NameServerService.delete: serviceName=%s,  address=%s",
                    serviceName, address));

    try {
      stub.delete(
          NameServerOuterClass.DeleteRequest.newBuilder()
              .setServiceName(serviceName)
              .setAddress(address)
              .build());
    } catch (StatusRuntimeException e) {
      throw new NameServerRPCFailureException("Delete", e.getStatus().getDescription());
    }
  }
}
