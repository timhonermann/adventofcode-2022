import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge3 {
  public static void main(String[] args) {
    var c3 = new Challenge3();

    int result1 = c3.solve1();
    int result2 = c3.solve2();
    System.out.println(result1);
    System.out.println(result2);
  }

  private int solve2() {
    int total = 0;
    var rucksacks = getRucksacks();
    var groupedRucksacks = getGroupedRucksacks(rucksacks);

    for (List<String> groupedRucksack : groupedRucksacks) {
      var first = groupedRucksack.get(0);
      var second = groupedRucksack.get(1);
      var third = groupedRucksack.get(2);

      List<Character> set1 = first.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
      List<Character> set2 = second.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
      List<Character> set3 = third.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

      set1.retainAll(set2);
      set1.retainAll(set3);

      total += getPriority(set1.get(0));
    }

    return total;
  }

  private int solve1() {
    var rucksacks = getRucksacks();
    int total = 0;

    for (String rucksack : rucksacks) {
      // Split the rucksack into two compartments
      String compartment1 = rucksack.substring(0, rucksack.length() / 2);
      String compartment2 = rucksack.substring(rucksack.length() / 2);

      // Create sets of characters for each compartment
      List<Character> set1 = compartment1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
      List<Character> set2 = compartment2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

      // Find the common item type between the compartments
      set1.retainAll(set2);

      // Add the priority of the common item type to the total
      total += getPriority(set1.get(0));
    }

    return total;
  }

  private int getPriority(Character character) {
    // Check if char is uppercase or lowercase
    if (Character.isUpperCase(character)) {
      return character - 'A' + 27;
    } else {
      return character - 'a' + 1;
    }
  }

  private List<List<String>> getGroupedRucksacks(List<String> rucksacks) {
    var groupedRucksacks = new ArrayList<List<String>>();
    var index = 0;

    while (index < rucksacks.size()) {
      var first = rucksacks.get(index);
      var second = rucksacks.get(index + 1);
      var third = rucksacks.get(index + 2);

      var group = List.of(first, second, third);
      groupedRucksacks.add(group);

      index += 3;
    }

    return groupedRucksacks;
  }

  private List<String> getRucksacks() {
    var input = "FzQrhQpJtJMFzlpplrTWjTnTTrjVsVvvTnTs\n" +
        "mScqSqqgcfPCqGPZcfGNSvTNsVVNSjNvWSNsNz\n" +
        "fPcPGqgCcHgFzQpJJtHtJH\n" +
        "DZDqqlrjplDHrNCmnBcHBMCRcJzb\n" +
        "RQFLStFvdcBbzdJbJM\n" +
        "PThQtwftTPFvtTPhvtFtfFtpZZllwjRNlsqNqqZjwpGlrZ\n" +
        "pPwtqgwJZPJLgQqSFlqhFFlqMd\n" +
        "DBmCWBBDWTRGvcVRTCCnnfQlFSdlzfhfdMWQfjhhQz\n" +
        "drmBVVCRgprPtrZp\n" +
        "HznjQjvmzDMVrQnMLJMMlfWgPSlJGWWJPl\n" +
        "BdcqqhcdBRpFhhZBthhctdJSJJWfgGFlJCSFgbWPCDJS\n" +
        "NdRTZdNqBwqtthpRBTTRqdtZrsLQVzrrzjzDwDsnmrQrnsrr\n" +
        "HZFZCFzZWszqsRTBZTNMhmthVTmhDppmMQVPpm\n" +
        "wjvSbJddvrvlrvnJSJJvlJmhPlhVPVtGVpQDBVMpphQP\n" +
        "frbrfrcvvnvjfwbcJgrrCBRsCFsNzRgRCHCqssRH\n" +
        "dDFNqNqZqPLNqvqTTvCLSPdZssGHClJQJcRHJGHHcHBcsMsQ\n" +
        "lrjmWgWWrhjgrppQHHMQrsQRJGcBJc\n" +
        "lVlmnwjmdTTSvVFN\n" +
        "FWNFHvQPmLGwwwSHtswwln\n" +
        "RfMJcDdfdcfdddfZjdchrtZmSmCZVtqVnZmrnrtC\n" +
        "JMmJcfjjphcghpgjhRGzGzBBGPFGNBvPTpFL\n" +
        "cVPVwStmmcQPBQPpSCppwhHZNNqHszNBhsNRNjqHzj\n" +
        "MfWdDgvdbnvgMTWgvgZfzmsZJHzNhqjqjRhJ\n" +
        "MDWMWGndMgFDnFLDwQrPPCSrCSVrlmGS\n" +
        "QLZmPdRdWmMsMDWZmsLWWrhMHcHGzHvGzFcvrvzNrc\n" +
        "tplSbLVBlvHHcFNnSr\n" +
        "VqfgwLlCJWmWQTfW\n" +
        "nRWvlvRbtLvdMCPFGL\n" +
        "wrfsJNNGhNzGrTgDMDLgPMLPfq\n" +
        "wcVhJQhwhrrBpmVblBRGSG\n" +
        "HHHcggrZLcQQcQll\n" +
        "GzfzTRTzmmFMwSNSwdSJQtNLNB\n" +
        "TGbmLMFTzVVVTMzmFMfFPMHPZhnjZCpHnhgnZnPWCPZZ\n" +
        "MRwwpVMHRspqVqwmccDlDrcHBBZgBl\n" +
        "jQfQQQjWWFBgmcgDfcZg\n" +
        "hvvSQzSnQQSWWQWSjTZVTRMshwVCssppwV\n" +
        "pvrTvCvtFppCHMMZcdDFdcZM\n" +
        "wLjTQnqljjSnlwjqjRgLcHHHMBDMZhBMHgHcbBDh\n" +
        "mqjqlSNqRqwSRrWCvzGmtfTfzs\n" +
        "TWScDCqCQQVBWDqWHsHswwBgRJzRhhHp\n" +
        "dPttGrvFfGjMjnjvshsJgsJLgghRgH\n" +
        "rFMlGdtjPffNnnrffSNcVCDqQqCQRqQRRN\n" +
        "GmBRbVpPbmJcwggBBgWW\n" +
        "LjsTCNNtddjHqLLgWwccqgfq\n" +
        "nsjNjntNtjHCsDwZmwZZVmmGSvSD\n" +
        "bwDDgNFtMMDbFsMbFwWWVcRcSpcgjgQWhWSp\n" +
        "lfTJJlvdfCffccWppRjRlcSc\n" +
        "RnzGdJJmsMNnMFtM\n" +
        "bsBTFsqqTTmFZTsQBWWznWCRshlJNJlCVh\n" +
        "GjGnDvDjvjPppHwwpwgrPPClJhNVRCzhhzJWlWlhNlvJ\n" +
        "ffdgLrgdLrDjdfHPbbZbttcBbcbLmntn\n" +
        "TNTwwvTTHNtTHNLLVqtqTSZBJnrnhhbrFJjZjnVZgghF\n" +
        "cplWfRlzcWfRCZZhFrGjBfjZjn\n" +
        "pddzDsRpDcclzCQMWBvNSmTTSqdvPPvqwqtT\n" +
        "DQTttwwLtQtVSDMJDRmmSS\n" +
        "ffsWfvrBWrPvwJhPhPSMPMVn\n" +
        "WsvsggFvwNLgHtNQ\n" +
        "llBbVDMTlFVdFDTbVggSVsqZqZZZqqvNJZJRNRWgtv\n" +
        "HhpjcHHvjPsqCsWcNcsq\n" +
        "GfpvnPvwFDTTFFDw\n" +
        "GMmFGMGFFgVwQHQwwM\n" +
        "cJtZNtZTbThcZtcZJJtTZWJPllgNgpPvVgpjHvQpRpHQNg\n" +
        "hWcJZcnhcJznbcBZLqSLDfCmHqnqCLsD\n" +
        "zQpjLpnhnsHTnlQLrMCCHPFrvvCMPcHm\n" +
        "ZfgdSBtNqBwlgSDfZDwtqSFvJCvrPrVvFmwCJFvrmmFV\n" +
        "dfbRNZBqDtgRNBNNNljLLjhGRGGWGLGTRhjz\n" +
        "hhrnfBzhtzZgDgDnBfrfDZsRpMNCNNWjwCCfGQGGNGCGQC\n" +
        "lcdPmHLSPDSdFDpQMLjCQQQCRGpN\n" +
        "lJSSbmPdVdVvdHbvSDFHHPlZqgBnttzgTsssTrqgbZbsTT\n" +
        "FsdsShrgggLDdbSDsgrGrlWHTpfRpTjjfFTzRTRjBWWp\n" +
        "mPvqCmJCqJNnPvPNPCvvLTTVjHjzNWHHTWRBRVTWVz\n" +
        "wJLvqPZmJtccncvZmJqqrghDGQwbdSGdsgGgQgQr\n" +
        "zFwtNJGtNFlpnwHccZjZbcpprsmc\n" +
        "PWQfBWhBgQgTWQRLThBqMSVDSbbDRsVDmsmZsSZDjr\n" +
        "fvQfWBfLqfTqhLhCvNFttJlCwGrrCC\n" +
        "fNrGLNrfNrGjllRRRPmWVL\n" +
        "tbJdcFbSSssZSmmpFcsSbwDWVWBlllVPDnnjBFjDRnBF\n" +
        "ZZJcvZctgNmmvMGhQm\n" +
        "HhhjFRhgrcRTFLvWVJVQWJVHDHQJPP\n" +
        "GwCmwBfGzfSCzCfwtmtzzJVWSVJJZrbWQQQqJJDZVJ\n" +
        "mtfzpGdststtBmfmCwrGRFcTcvjngjFnRcLnpLLn\n" +
        "rrwjdwLgVmVwHrfPCJPQBCBGmPtt\n" +
        "ccNZqbNnMMblNpTlNpnhhBPSJsQhJtJtChPJqS\n" +
        "vTWvNcWNWTFvnnvcgjzDLVQLgHVwWDrW\n" +
        "jNPgbNHbfLJgLzfz\n" +
        "ShvhhFVVDShFVqMSSSvZfffvPLtBBBBJJlpfLJJv\n" +
        "DqhnShhMnZZwCSDCMhChrRnNrNdNQbHNNPmjmdHN\n" +
        "VQVZGQFnzFTSsBfgzgfs\n" +
        "rjlpjtDrtMLZPMtPtpPZPwCsgSHgMHCCmCTWsgBWSBmg\n" +
        "pjvDqLwrlDtwqtqNLvtjpPPwRNbQRncQVQddZhRhJQbJncbG\n" +
        "PsBSqnSdQsFhmmmnppFc\n" +
        "TRhNvrTCvNTHVcfHbJVTpc\n" +
        "rhtWvGWLrjRqdSqqLLqdld\n" +
        "vPhfqPJvrMrnffDDhvpMjdzGMLdLLQpllLGQ\n" +
        "mbmcFSScGbSCcQlzwQQlclsg\n" +
        "BSGVCmCTZWCGGvnvfZHqqrDhHN\n" +
        "GSRfrzGRhzsGChjTBBlqBgjgCTCn\n" +
        "wHQwtDVDHwHHDJcDWJZwzHZBqTnnBFlvjFgBqnljjvBdBZ\n" +
        "JNmVJpVmNtDHJWHrbfPLhbGhrzRbpr\n" +
        "WcWcbzNPbDwBNvWBwRMPQmJZQRQZftRZGP\n" +
        "LhVHFgggTHCFHhfMQQSMMGQRMLLM\n" +
        "qnrqppFVHphqfDsNbzjrzbrN\n" +
        "cwgDrdLSrBrvvhDzCljjTW\n" +
        "VHtVZpspQtMQsVRQppFVQVHtCdPTPTzdjvhTzTTPRvjjvWhn\n" +
        "QQZpMdJsQFJHtMHdScwLwLJGrSScSwqw\n" +
        "ZsjNflGfRfRPrZNRFcffLwJdwcLdDBnwzzzDznVn\n" +
        "CTGvhhTqbtbgTqLJWdDntzWWdnLw\n" +
        "phCMgmQGvvHCvMhbTQQFsNsNFPZSfZjffmNsll\n" +
        "CNpCJHLNhhSSHZPgrFlFFWgpFpmzjj\n" +
        "qQttDVDwQGdQGvqDQfwbcVrrlljjzzmzrVJgrr\n" +
        "nvMDsqqqQvfvsqDnRSZHJPPZHhLHLS\n" +
        "RNNrrPfDNRQwQhjscghMqs\n" +
        "WVZlHvnZqtlLVLvwjwhsggTstMhwTw\n" +
        "vGHWLJlVWlmLVqRCGCFFNfqqGf\n" +
        "MNzqCnvqvqvCVLBvvCVCpVcRssncrPSTWGrPSPdGTcrP\n" +
        "hmHwFmQjFlhtZmHwtZjjddSSGcsdPrrGcQQQRGPW\n" +
        "fHbbFjlhZwmtwhfjmmwmmLbpLqzqvBzLzCvLNRMbNB\n" +
        "tQfLrtQPrrfDSSCVlDfLSrmbBjGvWjjLmWWWpWNNppmv\n" +
        "wdHhRTTndnRThdvnBFGpNBMnpvvp\n" +
        "JdqTHTHHRdqzsJRRzTRHscJdDSGCfDlqQZqlfZrZZCffqSSQ\n" +
        "hQMWLsgGJMMhsCHggQWhgspDWFPzZvPvptDvzvmtdtdF\n" +
        "BrBlrTBrNRbfnjNQlZDztPvpmpppmzvfdd\n" +
        "jQlQlqQVbVcsMgMgChhJVs\n" +
        "MtFMCTWRFRRtCRTTRTMGJddjLdstHvBzBHzHVVpL\n" +
        "lZSDnbDlnZPrbHpzJJsdSVJpBL\n" +
        "nNghhPrlZlgDTFhCfMFJRMQF\n" +
        "RGpPFZPRQZPFRGvpPQPpjvpmhnnCMjhmhgBgVgMVWBVgVM\n" +
        "wLtfNdNHmrNthCBgCbhnngWd\n" +
        "srSfwHfszsNmtswlrqQDGQFDRPJGDvzRppRJ\n" +
        "GVFFGvVWZLFsmssFRNfVvmGGJPpJTTqDBvTpqlpDvqbBtTPl\n" +
        "gQhzzChzrMQhjpzlzWzJpPpBJb\n" +
        "ghgWjcCjMgCHWdQMhdjChCmfwmRRGZZGVHLZHRfmNwVs\n" +
        "DnDVhdnrfSfpcGGjQQGdJddJ\n" +
        "bPWPRbRsRMsHNzDqTZcGBcqZqmmN\n" +
        "HvwPvvzMPwDCChDVwS\n" +
        "vTCCvTfWFDTtRPMvfWFlDFHBqGLpLzbwBgWwqzGqbBbB\n" +
        "cQcSNchSJSZShVJNnZrhSqBpgwGHHtGwqtbwLbqpbr\n" +
        "JNnJVsJscNstNhQsjnVVNlFfMmTMFfCTfjFvfPRPPF\n" +
        "VLFBsgffNFNqRvbz\n" +
        "ChltjTdjDhHpHZvdpjjZhwCpbNrbSzzbrNGMTMMNSMbWWNSN\n" +
        "vQjpttQhHnLsBQVLsQ\n" +
        "mbzQgTzRVVbsVdQgzzVRddmztFGWNGNNWnGtFSGBsrCNWCrC\n" +
        "jfJjvPPwLDcHDPvDDPDppLCWCFBGWntCBnrtFcrFWTGn\n" +
        "wpJPLjvpTTDpwhfgzmVMbqhdhVRgzl\n" +
        "PlcqbWClLmnqZVLq\n" +
        "THwdrrhddhhfJJhwLJhpQnDVnznnmZQQnSpfpD\n" +
        "vrFdvGsGHhhhwHjFGrFGJHdMCCcNgbWMPccRRccMFLNPPP\n" +
        "tbppJqcNtJnZzRJbPFsFPHfZrrshFDjj\n" +
        "GdwgwlLgGCndsDFrhDHHFF\n" +
        "SSlLnmmvqWNqmcqb\n" +
        "ZPFPPTZpZSWzCMMSzPBsFvhtlQvJQQtJhsVs\n" +
        "dmNbmgbrwDNmbcDgwNdcwdLsnhlJlnvtsBJnhVQqqnstLB\n" +
        "bNGfDGgHHVwbwNwVfgmRMzCzzCSHjSRZSZCTRS\n" +
        "dDTffQdqQQLBLnVLLQvL\n" +
        "rrBHZZcgJcrLvNLtLgRLbN\n" +
        "cjjJhrFlhZwFFzwJzmTBBdmTsDPzDsBP\n" +
        "ClGrJJMNCrGQqlcPvWgnDP\n" +
        "ZBvbjHpSwBVVVcWjjjqQ\n" +
        "BLSbbwsHSTBHwmLHHLbBsSTFdrfvCrtmdzfGJzrdzGJddGfh\n" +
        "gljWRwmSjtJWjJtJjgjSZfVSTVVHGZSVHcVchZ\n" +
        "pBzLFQpPsFBGcGBTThfB\n" +
        "pFpQzFLPLpvQFQnLbsqqGddgjbmwRldwtWmlGWwj\n" +
        "PDQDMFQBMfWPvjdLLndLjrmsMj\n" +
        "qZqVzTRRqHtvZGGtVqTTzVjLLsrmJCddnLjrjHsrhdCr\n" +
        "GzwcZtqNzqvNqwzZVGRwSzbpWfFbWPlWFpNDBfQfFNNf\n" +
        "dfRszdzVdsjwdhLwCCqwGllHvPGPwG\n" +
        "SpJtBLFgcGqHQClqZF\n" +
        "JrttrtcTmSSLrmtBTrNgnBJjbNhhbhzRdsVdMhNjhMMhVd\n" +
        "MPFSCfSMqVSBGrtzlvccfQctzbzl\n" +
        "hZNjTHWWTZwshbLvmlWpBzmbmm\n" +
        "dRTTJNDNhjsJqBBMMgrJPVVr\n" +
        "WnVzDMjlDVWwwHgwhmgNhNNsJh\n" +
        "qfvrLNCcbLdvpcvbrPPqCsGhSJGTTBspTshBpTBBms\n" +
        "ZLvvZfrPfPCLbCFFzjVQzRnNNMVzDQ\n" +
        "nllbFTTpTFTBcnCjQPqQdZRQZhCb\n" +
        "tvWszrrztvSmzQQvrDmZRjjjPPDVqPRdZRdCPd\n" +
        "gfzvSsftgQHQHgQl\n" +
        "GVbHRRGRLpdmGWTm\n" +
        "gSPPltPlrlvccFccPlcJNCTpnnmpMCLMMmWfdRmMSS\n" +
        "FzNJRhhvPFRvQwzqjqzBHZZj\n" +
        "PhZSpFBPBFsNmjBVllltBj\n" +
        "JMGLnrrnbfffrdqRqPHnnqLDVTDDjgmRgwtmjDljlDVlwl\n" +
        "LHMqPqPnnqGLWJPMnndrGfSWppzvvFSChFFFvvzQSQZz\n" +
        "RSWWssbvnnCqZnWsRCnssWrTggNhgbNHBgQjhhQBgjNT\n" +
        "mcpzcppzczcDGVcPcDLLGLjmrMNTNtQNHhMHrQBQNTgN\n" +
        "LVpPfcjjWvsFFnFf\n" +
        "MpddpdCpJdJlbdMvBHMnnsHqSRvG\n" +
        "PWvZfFmZrrfmwWwFznBnqRRSGcsBVmVBRG\n" +
        "zjzzhQPQvzjLPQzwffrwrtlTCDtJDlgJLltpTTJlTl\n" +
        "TvTWjjzpznGttFFZccrrPrSZllcB\n" +
        "gNNSqHMqsMHQJHNZCDDCZDqLZdlZBD\n" +
        "SMQNSRNbRRHwhwhsRmtnvWVmmnbGnjmpGn\n" +
        "ccSVQjCQddTsFJcH\n" +
        "gLppBfgfmvCRFdsddTJJgb\n" +
        "WMLMmWGGBZWZLCtvDhlSSDGlwhSPSzSP\n" +
        "TpqVGVHFQGmqSqPZdccNCzzhdwCjNG\n" +
        "fffbbvftMrBMDDcCccCZCjlvhCCd\n" +
        "RLWMnbftDhnMRtfBftRJMtLMgFgHmmpmPmSmmQFPPLHHVTQS\n" +
        "nRvwQSDNcpVJJcJR\n" +
        "qZMjBhjhZMMBzLBGLGrjJbTPVTpbdPPdVbVb\n" +
        "ZZpmFFZlfGqfmmGMzlfmMmnWQDtHtSvnWWNSHSSstFtS\n" +
        "bFDGZjGDbbRSgLtN\n" +
        "CphJVfJWCTBgvfLHNRcwnt\n" +
        "WVhPWBTzzChzhhhBmrpPPCJZDQtdMlrjFQdrFqsjdrQsFG\n" +
        "ZBpVQHHVMMWWdmmLWw\n" +
        "lQhhrjcRttrqbvQLNwdDWzmNSDmStz\n" +
        "QbGqhcbvcsqvCCHnsCZHCnTn\n" +
        "tlWtQTTTJjTQtVnmrbnPWVShVC\n" +
        "MDMGGzsHcwFgGZBqrmmPSnbqVmNVGC\n" +
        "sZFPwHcMZDBRTlvQQJttTQTR\n" +
        "FhVRfGptMGMnZhRFBNRBCCNHHNvTNTRC\n" +
        "zmwrLLSjrbzmNlcvvrHvDPCN\n" +
        "JLwjQdSbjdbSdqJQFGVqFVMgnGHMfGVV\n" +
        "fffZWrJqZSHWTWHqSvrgDhggzRjttsDhpDgs\n" +
        "PGlBLcBBbnnbLLFbGLBjRgjFTFVzshtzpgsppz\n" +
        "TGCPnMPQlGnPmclPlnnQmbmHJvNvfHdqwddwvvZfCNHCfW\n" +
        "ClLwpspTPrTFZCdzFbZdbQ\n" +
        "RRMWfRgWVRMRQBZZScVczVGFbjNb\n" +
        "MfnvMqWmslvDhQPw\n" +
        "hdndSdqsTddBhdcmmNHFDcqHttPF\n" +
        "JjMzzMZQGwZGZJzMzZJQzGJFvPvNPtFmvmNmDvcFtvDHMv\n" +
        "gZwzQwJfGVJQJbGLBsSTSTdTbCWDBSnd\n" +
        "ZZCHZRzMZGRMhMMVVFNThrdd\n" +
        "SgsccSPmmgqssSlqsgcmscSqlhpFdVThjphNrdrhjdwdhFJN\n" +
        "vmttqTcqvLqqmPccmqSBbRWnWzQZZZZBHnQCzHDH\n" +
        "GgPnGdSPBpGsLTBL\n" +
        "rVNJjmwZqtZZshltFTtvRFsL\n" +
        "mqmWrZVqWjrqZMNwPMQQbsddgdsbsgPz\n" +
        "LZLVvjZrggHLJggSZDgrnPnQnRnppVRllntRdPFz\n" +
        "chMCzbqGmhNhhbBCMBdFnpfqFnltRRQnlPpQ\n" +
        "TChmWcMMTmBswJzZZrWrvzgg\n" +
        "gngRNBNRBsNFFBgfgbLLLnqdSLvLTcbLbd\n" +
        "GWtlChlVMllcZSDWSLbdZL\n" +
        "lljjGlhMGrGJpsFdRJfsfzfz\n" +
        "jVTdrnGQcQtTTTFQqBqsgHHFgsqf\n" +
        "ZZLbPLzDzPZCmsgqsBHt\n" +
        "wDzDlPblRDPLPvhvwtdnnhdrnrMGWMVGMThj\n" +
        "spjjpjvjpjmQjrpCMfSlfzrPBl\n" +
        "dHFntHWnnbRVFtnbcqHFzBCCCPzfPMlcCSlgllzc\n" +
        "RLbVWHnnSWtnHFbdbVRdNNtQsjsQTjDLwmGTmTssQwmLGJ\n" +
        "JbJJSLMhRMSLhNqqwFDwFNcFqL\n" +
        "GcpnGnznnpzpzGpffNTNTwTfwdDNNdTFdD\n" +
        "nllnlPGWQWHcGpzzQGGzGvHGJbVVtJSChQVbmtmVJrmrmbRm\n" +
        "GFsFrzwrflmtdtbltG\n" +
        "ggLPDngCJncNLJRDwgnllmJqjWMjhjhjWWmWjj\n" +
        "nBNRNPgpRgDLTgNwfsSHVBQHVHwsZr\n" +
        "WwvnvWvcFtwtSFSF\n" +
        "zBZZZRQSzMBSgSVJGjGTPTGFzCzmmj\n" +
        "fZDrpZZfRfMgSQDDBhgQghDHsnbrcNlWnnLWHLrHsWnllc\n" +
        "ZVncdPPwVPdhZngnqHWHNNvTHvlMvn\n" +
        "fSLjjLSGGBjTTHqvBqrMNT\n" +
        "RSSSDGRtSGZthTTctmtg\n" +
        "rtzrfJbgJHRfGRZLPR\n" +
        "hdVhlllmFlFPLwHmsRGGZP\n" +
        "nTWhRjTBTWlvNQgnJSSbrJtz\n" +
        "JgVTpBpfvgpTDDJFJvTgggtlFlNNMRLNNzNNZRNHMRCLlF\n" +
        "wbPWcSGbGqWDlnNWMMMCLMWZ\n" +
        "wrsGcbrcbcqwDwbcmGvQBQgTTsdVJgJsVdQf\n" +
        "mztrhgJtDrhgcrZmnhbnzbhcMTMPlBCPBGVGTMVGslCCPGDs\n" +
        "FLRQmjjFSQpQwLlPsMsCpvslvPCB\n" +
        "fNLLwSdSwWSWjwmrtczZhhrJzdzh\n" +
        "HHwCwJFmHZttZCfCSffSMHcVDMcPBRPcPRDhPghM\n" +
        "nvQLsTnLslnLvpzGTssnsRPDMhPgVPVgtcVMRPgVQQ\n" +
        "vnsTGWlTLsWTLLvNsGWlsZrwmZCJddjFmtJJNZFftj\n" +
        "hbjSTvSJTfcSwcPSPfTbfHszVVFpGnpJpsHFnHVVls\n" +
        "rtZrcQrRZZQrmZBQlCGppnppHzpVFCGR\n" +
        "WmLqmgNtcLNQWTbPvfPwbbdb\n" +
        "HzZgsdHglHlzdHsFtsNNJSlNcSpjcjlrrNVv\n" +
        "wqqWRPPqwmbcqPjQVvSPJJrVpv\n" +
        "qqBBqmWRhqRLqcBnhzzztgnTdDHnHsFsHn\n" +
        "rJPFVwwsrJwmdVrLWJvvRBWBvbzWlb\n" +
        "nDZcNGNpjTpHncvpZCDnTNZGhlWzQhWbpRRQlQhpWWSWLlQb\n" +
        "CDNntnCCHnvmqPfwtFdVqd\n" +
        "gqBwgBjCswwgqNBNCVDDTVdhlSDTDcZc\n" +
        "HvRRFMzRRRRMpHrtTllfhZHHSShHTf\n" +
        "PmlGLPrppMrrmFFmLMWRjbsjnsjwQNJWnbQjWgBN\n" +
        "pDggpFgRghZjBFPPnPPFrt\n" +
        "cwTfLwBVwCWbLcVTVVvrdndGjMHrnGJtnttdMC\n" +
        "NTVcWNvcBSpgNqspRQlN\n" +
        "DLDgFlDmNZfjfnJZSF\n" +
        "tctvttzvGGzvrHqtVVdwnJGSSnnjjZdWTdwW\n" +
        "zvpcrbpHpqJJsPbPlLlhmhglPQ\n" +
        "pvHHvssFCFZQNCftttdQdd\n" +
        "VgTGTTVGgLjDjlLGzgPVMTNwmcwQmMQfQtmdcmwMJwNm\n" +
        "TPjTDjfGWTLLljgzrWpZZbsqrFqhqbps\n" +
        "ppVLcfcwSLgpSLVLgWwtfshDNDqvWvGvlQZvDNHQHjqq\n" +
        "MPrzmdRrPPrCJFnMnMRRFRPdqqZQNQvjvZDGDlHhQvGNDG\n" +
        "BmBMBBJTMmPBJMMFCCFJRmrsTlVpVbpwLSVwLsgcwTVlVc\n" +
        "SSGzmFRzmRGLgSSmGMJFnvfvJnJVnJQnMl\n" +
        "cBpjHtjwNfcpNZtppHtCMlMPMlJBVlVQlvJPvJ\n" +
        "dNtNZwqWfqtqZWtHttsqHqrRrrdRTLbmmzSLmTGGmbrg\n" +
        "RrrddnrgnRbbgWdGrfnwgQwjDjDpvTpBQTwBPP\n" +
        "MHCStZJzSwvPjWQD\n" +
        "mcJWVHCCLcGLbdcn\n" +
        "PlMsdjPdGMjdPSrSjgddbLbmHHTszHZzpHmsTFvmpzZzmN\n" +
        "ntRJQVRfcQhcQWhnchBJWntTFTTTNTSpFtztmZFDTpDZ\n" +
        "hQfcfCBSwCccVJhSJnrPPGLqPlbPLCrqldgb\n" +
        "vgvWDMZvGpcqgqsP\n" +
        "tSdtjLHLQLHjdFdDddQSQhwlsGqwQlqqqhQsPhGc\n" +
        "tbRjtTLFRvTZDBrMrV";

    return Arrays.asList(input.split("\n"));
  }
}
