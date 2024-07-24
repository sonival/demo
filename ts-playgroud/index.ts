import { createServer, IncomingMessage, ServerResponse } from "http";

const port:number = 3000;
const server = createServer();

server.on("request", (_: IncomingMessage, res: ServerResponse) => {
  const responseStatus: number = 200;
  res.writeHead(responseStatus, { "Content-Type": "application/json" });
  res.end(
    JSON.stringify({
      data: "its okey",
    }),
  );
});

server.listen(port, () => console.log(`Executando na porta  ${port} , UAU!!`));